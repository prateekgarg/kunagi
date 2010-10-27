package scrum.client.collaboration;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.AFieldValueWidget;
import ilarkesto.gwt.client.TableBuilder;

import java.util.List;

import scrum.client.ScrumGwt;
import scrum.client.admin.ProjectUserConfig;
import scrum.client.admin.User;
import scrum.client.common.AScrumWidget;
import scrum.client.issues.Issue;
import scrum.client.project.Project;
import scrum.client.sprint.Task;

import com.google.gwt.user.client.ui.Widget;

public class UserStatusDetailsWidget extends AScrumWidget {

	private User user;

	public UserStatusDetailsWidget(User user) {
		super();
		this.user = user;
	}

	@Override
	protected Widget onInitialization() {
		final Project project = Scope.get().getComponent(Project.class);
		TableBuilder tb = ScrumGwt.createFieldTable();
		tb.setColumnWidths(40);
		if (user != getCurrentUser()) {
			tb.addFieldRow("Idle", new AFieldValueWidget() {

				@Override
				protected void onUpdate() {
					ProjectUserConfig config = project.getUserConfig(user);
					setText(config.getIdleTimeAsString());
				}
			});
		}
		tb.addFieldRow("Tasks", new AFieldValueWidget() {

			@Override
			protected void onUpdate() {
				List<Task> tasks = project.getCurrentSprint().getClaimedTasks(user);
				setContent(ScrumGwt.createReferencesWidget(tasks));
			}
		});
		tb.addFieldRow("Issues", new AFieldValueWidget() {

			@Override
			protected void onUpdate() {
				List<Issue> issues = project.getClaimedBugs(user);
				setContent(ScrumGwt.createReferencesWidget(issues));
			}
		});
		return tb.createTable();
	}

}
