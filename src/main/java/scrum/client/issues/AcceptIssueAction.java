package scrum.client.issues;

public class AcceptIssueAction extends GAcceptIssueAction {

	public AcceptIssueAction(scrum.client.issues.Issue issue) {
		super(issue);
	}

	@Override
	public boolean isExecutable() {
		if (issue.isClosed()) return false;
		if (issue.isSuspended()) return false;
		if (issue.isAccepted()) return false;
		return true;
	}

	@Override
	public String getLabel() {
		return "Accept as bug";
	}

	@Override
	public String getTooltip() {
		return "Accept this issue as urgend bug in a published release. The team needs to fix this immediately.";
	}

	@Override
	protected void onExecute() {
		issue.accept();
		addUndo(new Undo());
	}

	class Undo extends ALocalUndo {

		@Override
		public String getLabel() {
			return "Undo Accept as bug: " + issue.getReference() + " " + issue.getLabel();
		}

		@Override
		protected void onUndo() {
			issue.reopen();
		}

	}

}