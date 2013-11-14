// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class MoveRequirementToProjectServiceCall extends scrum.client.core.AServiceCall {

	private String projectId;

	private String requirementId;

	public MoveRequirementToProjectServiceCall(String projectId, String requirementId) {
		this.projectId = projectId;
		this.requirementId = requirementId;
	}

	@Override
	public void execute(Runnable returnHandler) {
		serviceCaller.onServiceCall(this);
		serviceCaller.getService().moveRequirementToProject(serviceCaller.getConversationNumber(), projectId,
			requirementId, new DefaultCallback(this, returnHandler));
	}

	@Override
	public String toString() {
		return "MoveRequirementToProject";
	}

}
