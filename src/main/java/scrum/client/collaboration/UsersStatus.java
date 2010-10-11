package scrum.client.collaboration;

import ilarkesto.gwt.client.AGwtEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import scrum.client.admin.User;
import scrum.client.workspace.BlockCollapsedEvent;
import scrum.client.workspace.BlockCollapsedHandler;
import scrum.client.workspace.BlockExpandedEvent;
import scrum.client.workspace.BlockExpandedHandler;

public class UsersStatus extends GUsersStatus implements BlockCollapsedHandler, BlockExpandedHandler {

	private Set<AGwtEntity> selectedEntities = new HashSet<AGwtEntity>();

	@Override
	public void onBlockExpanded(BlockExpandedEvent event) {
		Object object = event.getObject();
		if (object instanceof AGwtEntity) {
			addSelectedEntity((AGwtEntity) object);
		}
	}

	@Override
	public void onBlockCollapsed(BlockCollapsedEvent event) {
		Object object = event.getObject();
		if (object instanceof AGwtEntity) {
			removeSelectedEntity((AGwtEntity) object);
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
		return project.getUserConfig(user).isOnline();
	}

	private void addSelectedEntity(AGwtEntity entity) {
		project.getUserConfig(getCurrentUser()).addSelectedEntityId(entity.getId());
	}

	private void removeSelectedEntity(AGwtEntity entity) {
		project.getUserConfig(getCurrentUser()).removeSelectedEntityId(entity.getId());
	}

	private User getCurrentUser() {
		return auth.getUser();
	}

}