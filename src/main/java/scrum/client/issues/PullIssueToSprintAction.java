package scrum.client.issues;

import scrum.client.common.TooltipBuilder;
import scrum.client.sprint.PullIssueToSprintServiceCall;

public class PullIssueToSprintAction extends GPullIssueToSprintAction {

	public PullIssueToSprintAction(scrum.client.issues.Issue issue) {
		super(issue);
	}

	@Override
	public String getLabel() {
		return "Pull to Sprint";
	}

	@Override
	protected void updateTooltip(TooltipBuilder tb) {
		tb.setText("Add this Bug to the current Sprint.");
		if (!getCurrentProject().isTeamMember(getCurrentUser())) {
			tb.addRemark(TooltipBuilder.NOT_TEAM);
		} else {
			if (issue.isClosed()) tb.addRemark("Bug is already closed.");
		}
	}

	@Override
	public boolean isPermitted() {
		return issue.getProject().isTeamMember(getCurrentUser());
	}

	@Override
	public boolean isExecutable() {
		return !issue.isInSprint();
	}

	@Override
	protected void onExecute() {
		new PullIssueToSprintServiceCall(getId());
	}

}