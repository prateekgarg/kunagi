package scrum.client.collaboration;

import ilarkesto.core.base.Str;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.Gwt;

import java.util.Collections;
import java.util.List;

import scrum.client.admin.User;
import scrum.client.common.AScrumGwtEntity;
import scrum.client.common.AScrumWidget;
import scrum.client.common.LabelSupport;
import scrum.client.common.ReferenceSupport;
import scrum.client.workspace.Navigator;
import scrum.client.workspace.ProjectWorkspaceWidgets;

import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class UserStatusWidget extends AScrumWidget {

	private User user;
	private UsersStatus usersStatus;
	private Label nameLabel;
	private SimplePanel selectedEntitiesWrapper;
	private FlowPanel wrapper;

	private List<AScrumGwtEntity> selectedEntities = Collections.emptyList();

	public UserStatusWidget(User user) {
		this.user = user;
	}

	@Override
	protected Widget onInitialization() {
		usersStatus = Scope.get().getComponent(UsersStatus.class);

		nameLabel = new Label(user.getName() + getCurrentProject().getUsersRolesAsString(user, " (", ")"));
		nameLabel.setStyleName("UserStatusWidget-name");

		selectedEntitiesWrapper = new SimplePanel();
		selectedEntitiesWrapper.setStyleName("UserStatusWidget-selectedEntities");

		FlowPanel headerPanel = new FlowPanel();
		headerPanel.setStyleName("UserStatusWidget-header");
		headerPanel.add(nameLabel);
		headerPanel.add(selectedEntitiesWrapper);
		headerPanel.add(Gwt.createFloatClear());

		wrapper = new FlowPanel();
		wrapper.setStyleName("UserStatusWidget");
		wrapper.add(headerPanel);
		return wrapper;
	}

	@Override
	protected void onUpdate() {
		String color = getCurrentProject().getUserConfig(user).getColor();
		nameLabel.getElement().getStyle().setProperty("color", color);
		Highlighter highlighter = new Highlighter();
		nameLabel.addMouseMoveHandler(highlighter);
		nameLabel.addMouseOutHandler(highlighter);
		if (usersStatus.isOnline(user) || user == getCurrentUser()) {
			nameLabel.addStyleDependentName("online");
		} else {
			nameLabel.removeStyleDependentName("online");
		}
		List<AScrumGwtEntity> selectedEntities = usersStatus.getSelectedEntities(user);
		if (!this.selectedEntities.equals(selectedEntities)) {
			this.selectedEntities = selectedEntities;
			StringBuilder sb = new StringBuilder();
			for (AScrumGwtEntity entity : selectedEntities) {
				if (entity instanceof ReferenceSupport && entity instanceof LabelSupport) {
					sb.append(" <a href='").append(Navigator.getEntityHref(entity)).append("' title='")
							.append(Str.toHtml(((LabelSupport) entity).getLabel())).append("'>");
					sb.append(((ReferenceSupport) entity).getReference());
					sb.append("</a>");
				}
			}
			selectedEntitiesWrapper.setWidget(new HTML(sb.toString()));
		}
	}

	class Highlighter implements MouseMoveHandler, MouseOutHandler {

		@Override
		public void onMouseMove(MouseMoveEvent event) {
			Scope.get().getComponent(ProjectWorkspaceWidgets.class).highlightUser(user);
		}

		@Override
		public void onMouseOut(MouseOutEvent event) {
			Scope.get().getComponent(ProjectWorkspaceWidgets.class).highlightUser(null);
		}
	}
}
