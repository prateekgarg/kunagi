package scrum.client.issues;

import scrum.client.common.TooltipBuilder;
import scrum.client.sprint.KickIssueFromSprintServiceCall;

public class KickIssueFromSprintAction extends GKickIssueFromSprintAction {

	public KickIssueFromSprintAction(scrum.client.issues.Issue issue) {
		super(issue);
	}

	@Override
	public String getLabel() {
		return "Kick from Sprint";
	}

	@Override
	protected void updateTooltip(TooltipBuilder tb) {
		tb.setText("Remove this Bug from the current Sprint.");
		if (!issue.getProject().isProductOwner((getCurrentUser()))) {
			tb.addRemark(TooltipBuilder.NOT_PRODUCT_OWNER);
		} else {
			if (!issue.isSprintSet()) tb.addRemark("Bug is not in the current Sprint.");
		}
	}

	@Override
	public boolean isPermitted() {
		return issue.getProject().isProductOwner(getCurrentUser());
	}

	@Override
	public boolean isExecutable() {
		return issue.isInSprint();
	}

	@Override
	protected void onExecute() {
		new KickIssueFromSprintServiceCall(issue.getId()).execute();
	}

}