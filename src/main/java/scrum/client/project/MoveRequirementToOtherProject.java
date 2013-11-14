package scrum.client.project;

import scrum.client.common.TooltipBuilder;
import scrum.client.files.ProjectSelectionWidget;

public class MoveRequirementToOtherProject extends GSplitRequirementAction {

	public MoveRequirementToOtherProject(Requirement requirement) {
		super(requirement);
	}

	@Override
	public String getLabel() {
		return "Move Story to Project";
	}

	@Override
	public void updateTooltip(TooltipBuilder tb) {
		tb.setText("Move Story to other Project");
		if (!requirement.getProject().isProductOwner(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_PRODUCT_OWNER);
	}

	@Override
	public boolean isPermitted() {
		if (!requirement.getProject().isProductOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		ProjectSelectionWidget widget = new ProjectSelectionWidget(this, requirement.getId(), requirement.getProject()
				.getId());
		widget.showDialog();

	}

	public void executeMove(String projectId, String requirementId) {
		new MoveRequirementToProjectServiceCall(projectId, requirementId).execute();
		addUndo(new Undo(requirement));
	}

	class Undo extends ALocalUndo {

		private Requirement requirement;

		private Project oldProject;

		public Undo(Requirement requirement) {
			super();
			oldProject = requirement.getProject();
			this.requirement = requirement;
		}

		@Override
		public String getLabel() {
			return "Undo move story " + requirement.getReferenceAndLabel();
		}

		@Override
		protected void onUndo() {
			new MoveRequirementToProjectServiceCall(oldProject.getId(), requirement.getId()).execute();
		}
	}
}