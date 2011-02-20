package scrum.client.statistics;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.HyperlinkWidget;
import ilarkesto.gwt.client.SwitchingNavigatorWidget;
import ilarkesto.gwt.client.TableBuilder;

import java.util.LinkedList;
import java.util.List;

import scrum.client.admin.User;
import scrum.client.common.AScrumWidget;
import scrum.client.project.Project;
import scrum.client.workspace.PagePanel;
import scrum.client.workspace.ProjectWorkspaceWidgets;

import com.google.gwt.user.client.ui.Widget;

public class UserStatisticsWidget extends AScrumWidget {

	@Override
	protected Widget onInitialization() {
		ProjectWorkspaceWidgets widgets = Scope.get().getComponent(ProjectWorkspaceWidgets.class);

		SwitchingNavigatorWidget nav = widgets.getSidebar().getNavigator();

		PagePanel usersBurndown = new PagePanel();
		Project project = getCurrentProject();
		List<User> team = new LinkedList<User>(project.getTeamMembers());
		User currentUser = getCurrentUser();
		if (team.contains(currentUser)) {
			team.remove(currentUser);
			team.add(0, currentUser);
		}
		for (User user : team) {
			usersBurndown.addHeader(user.getName() + "'s burndown",
				new HyperlinkWidget(nav.createSwitchAction(widgets.getSprintBacklog())));
			usersBurndown.addSection(new UserWorkWidget(user.getName()));
		}

		PagePanel burnHours = new PagePanel();
		burnHours.addHeader("Team burned hours", new HyperlinkWidget(nav.createSwitchAction(widgets.getWhiteboard())),
			new HyperlinkWidget(nav.createSwitchAction(widgets.getIssueList())));
		burnHours.addSection(new BurnHoursWidget());

		Widget left = TableBuilder.column(5, usersBurndown);
		Widget right = TableBuilder.column(5, burnHours);

		return TableBuilder.row(5, left, right);
	}

}
