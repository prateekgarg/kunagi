package scrum.client.project;

import ilarkesto.core.scope.Scope;
import scrum.client.common.TooltipBuilder;
import scrum.client.workspace.ProjectWorkspaceWidgets;

public class CreateRequirementAction extends GCreateRequirementAction {

	private Requirement relative;
	private boolean before;

	@Override
	public String getLabel() {
		return "Create Story";
	}

	@Override
	public boolean isExecutable() {
		return true;
	}

	@Override
	public String getTooltip() {
		TooltipBuilder tb = new TooltipBuilder("Create a new Story.");

		if (!getCurrentProject().isProductOwner(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_PRODUCT_OWNER);

		return tb.getTooltip();
	}

	@Override
	public boolean isPermitted() {
		if (!getCurrentProject().isProductOwner(getCurrentUser())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		Requirement requirement = getCurrentProject().createNewRequirement(relative, before);
		Scope.get().getComponent(ProjectWorkspaceWidgets.class).showProductBacklog(requirement);
	}

	public void setRelative(Requirement nextRequirement) {
		this.relative = nextRequirement;
	}

	public void setBefore(boolean before) {
		this.before = before;
	}

}
