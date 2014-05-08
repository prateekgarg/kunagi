// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class RequestHistoryServiceCall extends scrum.client.core.AServiceCall {

    public  RequestHistoryServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestHistory(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestHistory";
    }

}

