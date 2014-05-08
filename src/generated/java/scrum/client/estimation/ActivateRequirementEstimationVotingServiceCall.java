// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.estimation;

public class ActivateRequirementEstimationVotingServiceCall extends scrum.client.core.AServiceCall {

    private String requirementId;

    public  ActivateRequirementEstimationVotingServiceCall(String requirementId) {
        this.requirementId = requirementId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().activateRequirementEstimationVoting(conversationNumber, requirementId, callback);
    }

    @Override
    public String toString() {
        return "ActivateRequirementEstimationVoting";
    }

}

