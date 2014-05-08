// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class MoveRequirementToProjectServiceCall extends scrum.client.core.AServiceCall {

    private String destinationProjectId;

    private String requirementId;

    public  MoveRequirementToProjectServiceCall(String destinationProjectId, String requirementId) {
        this.destinationProjectId = destinationProjectId;
        this.requirementId = requirementId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().moveRequirementToProject(conversationNumber, destinationProjectId, requirementId, callback);
    }

    @Override
    public String toString() {
        return "MoveRequirementToProject";
    }

}

