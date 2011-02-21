package scrum.client.statistics;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.Date;
import ilarkesto.gwt.client.HyperlinkWidget;
import ilarkesto.gwt.client.SwitchingNavigatorWidget;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.admin.User;
import scrum.client.common.AScrumWidget;
import scrum.client.workspace.PagePanel;
import scrum.client.workspace.ProjectWorkspaceWidgets;

import com.google.gwt.user.client.ui.Widget;

public class MyStatisticsWidget extends AScrumWidget {

	@Override
	protected Widget onInitialization() {
		ProjectWorkspaceWidgets widgets = Scope.get().getComponent(ProjectWorkspaceWidgets.class);

		SwitchingNavigatorWidget nav = widgets.getSidebar().getNavigator();

		PagePanel teamBurndown = new PagePanel();
		teamBurndown.addHeader("Team burndown");
		teamBurndown.addSection(new UserWorkWidget());

		PagePanel currentUserBurndown = new PagePanel();
		User currentUser = getCurrentUser();
		currentUserBurndown.addHeader("My burndown",
			new HyperlinkWidget(nav.createSwitchAction(widgets.getSprintBacklog())));
		currentUserBurndown.addSection(new UserWorkWidget(currentUser.getName()));

		PagePanel todayBurnHours = new PagePanel();
		todayBurnHours.addHeader("My burned hours today",
			new HyperlinkWidget(nav.createSwitchAction(widgets.getWhiteboard())),
			new HyperlinkWidget(nav.createSwitchAction(widgets.getIssueList())));
		todayBurnHours.addSection(new BurnHoursWidget(Date.today(), currentUser));

		PagePanel beforeBurnHours = new PagePanel();
		Date dateBefore = null;
		for (int x = 1; x < 5; x++) {
			dateBefore = Date.today().addDays(-x);
			beforeBurnHours.addHeader("My burned hours on " + dateBefore);
			beforeBurnHours.addSection(new BurnHoursWidget(dateBefore, currentUser));
		}

		Widget left = TableBuilder.column(5, teamBurndown, currentUserBurndown);
		Widget right = TableBuilder.column(5, todayBurnHours, beforeBurnHours);

		return TableBuilder.row(5, left, right);
	}

}
