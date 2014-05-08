// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.journal;

public class RequestProjectEventsServiceCall extends scrum.client.core.AServiceCall {

    public  RequestProjectEventsServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestProjectEvents(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestProjectEvents";
    }

}

