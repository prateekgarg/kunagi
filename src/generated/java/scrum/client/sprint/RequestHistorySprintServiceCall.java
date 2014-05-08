// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class RequestHistorySprintServiceCall extends scrum.client.core.AServiceCall {

    private String sprintId;

    public  RequestHistorySprintServiceCall(String sprintId) {
        this.sprintId = sprintId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestHistorySprint(conversationNumber, sprintId, callback);
    }

    @Override
    public String toString() {
        return "RequestHistorySprint";
    }

}

