package scrum.client.project;

import scrum.client.common.TooltipBuilder;
import scrum.client.files.ProjectSelectionWidget;

public class MoveRequirementToOtherProject extends GSplitRequirementAction {

	public MoveRequirementToOtherProject(scrum.client.project.Requirement requirement) {
		super(requirement);
	}

	@Override
	public String getLabel() {
		return "Move Story to project";
	}

	@Override
	public void updateTooltip(TooltipBuilder tb) {
		tb.setText("Move Story to other project");
		if (!requirement.getProject().isProductOwner(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_PRODUCT_OWNER);
	}

	@Override
	public boolean isPermitted() {
		// if (!requirement.getProject().isProductOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		ProjectSelectionWidget uploadWidget = ProjectSelectionWidget.showDialog(null);
		// Requirement newRequirement = requirement.getProject().createNewRequirement(requirement, true,
		// true);
		// Scope.get().getComponent(ProjectWorkspaceWidgets.class).showEntity(newRequirement);
		// addUndo(new Undo(newRequirement));
	}

	class Undo extends ALocalUndo {

		private Requirement newRequirement;

		public Undo(Requirement newRequirement) {
			super();
			this.newRequirement = newRequirement;
		}

		@Override
		public String getLabel() {
			return "Undo move story " + requirement.getReferenceAndLabel();
		}

		@Override
		protected void onUndo() {
			// getDao().deleteRequirement(newRequirement);
		}
	}
}