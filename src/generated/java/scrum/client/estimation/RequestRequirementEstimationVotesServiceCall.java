// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.estimation;

public class RequestRequirementEstimationVotesServiceCall extends scrum.client.core.AServiceCall {

    private String requirementId;

    public  RequestRequirementEstimationVotesServiceCall(String requirementId) {
        this.requirementId = requirementId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestRequirementEstimationVotes(conversationNumber, requirementId, callback);
    }

    @Override
    public String toString() {
        return "RequestRequirementEstimationVotes";
    }

}

