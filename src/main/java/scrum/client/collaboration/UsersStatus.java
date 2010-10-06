package scrum.client.collaboration;

import ilarkesto.gwt.client.AGwtEntity;
import ilarkesto.gwt.client.EntityDoesNotExistException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import scrum.client.DataTransferObject;
import scrum.client.UsersStatusData;
import scrum.client.UsersStatusData.UserStatus;
import scrum.client.admin.User;
import scrum.client.communication.ServerDataReceivedEvent;
import scrum.client.communication.ServerDataReceivedHandler;
import scrum.client.workspace.BlockCollapsedEvent;
import scrum.client.workspace.BlockCollapsedHandler;
import scrum.client.workspace.BlockExpandedEvent;
import scrum.client.workspace.BlockExpandedHandler;
import scrum.client.workspace.VisibleDataChangedEvent;

public class UsersStatus extends GUsersStatus implements ServerDataReceivedHandler, BlockCollapsedHandler,
		BlockExpandedHandler {

	private UsersStatusData usersStatus = new UsersStatusData();

	@Override
	public void onBlockExpanded(BlockExpandedEvent event) {
		Object object = event.getObject();
		if (object instanceof AGwtEntity) {
			addSelectedEntityId(((AGwtEntity) object).getId());
		}
	}

	@Override
	public void onBlockCollapsed(BlockCollapsedEvent event) {
		Object object = event.getObject();
		if (object instanceof AGwtEntity) {
			removeSelectedEntityId(((AGwtEntity) object).getId());
		}
	}

	@Override
	public void onServerDataReceived(ServerDataReceivedEvent event) {
		DataTransferObject data = event.getData();
		if (data.usersStatus != null) {
			usersStatus = data.usersStatus;
			log.debug("usersStatus updated:", usersStatus);
			for (AGwtEntity entity : getSelectedEntities()) {
				entity.updateLocalModificationTime();
			}
			new VisibleDataChangedEvent().fireInCurrentScope();
		}
	}

	public List<User> getOnlineUsers() {
		List<User> ret = new ArrayList<User>();
		for (User user : project.getParticipants()) {
			if (isOnline(user)) ret.add(user);
		}
		return ret;
	}

	public boolean isOnline(User user) {
		return usersStatus.get(user.getId()).isOnline();
	}

	public Set<String> getSelectedEntitysIds(User user) {
		return usersStatus.get(user.getId()).getSelectedEntitysIds();
	}

	public Set<AGwtEntity> getSelectedEntities() {
		Set<AGwtEntity> ret = new HashSet<AGwtEntity>();
		for (UserStatus status : usersStatus.getAll()) {
			Collection<String> ids = status.getSelectedEntitysIds();
			for (String id : ids) {
				try {
					AGwtEntity entity = dao.getEntity(id);
					ret.add(entity);
				} catch (EntityDoesNotExistException ex) {}
			}
		}
		return ret;
	}

	private void addSelectedEntityId(String id) {
		String userId = getCurrentUser().getId();
		boolean added = usersStatus.addSelectedEntityId(userId, id);
		if (added) new SetSelectedEntitysIdsServiceCall(usersStatus.get(userId).getSelectedEntitysIds()).execute();
	}

	private void removeSelectedEntityId(String id) {
		String userId = getCurrentUser().getId();
		boolean removed = usersStatus.removeSelectedEntityId(userId, id);
		if (removed) new SetSelectedEntitysIdsServiceCall(usersStatus.get(userId).getSelectedEntitysIds()).execute();
	}

	private User getCurrentUser() {
		return auth.getUser();
	}

}