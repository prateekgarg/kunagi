package scrum.client.issues;

public class UnclaimIssueAction extends GUnclaimIssueAction {

	public UnclaimIssueAction(scrum.client.issues.Issue issue) {
		super(issue);
	}

	@Override
	public String getLabel() {
		return "Unclaim";
	}

	@Override
	public boolean isExecutable() {
		if (!issue.isOwnerSet()) return false;
		return true;
	}

	@Override
	public boolean isPermitted() {
		if (!issue.isOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		issue.setOwner(null);
	}

}