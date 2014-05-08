// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.issues;

public class RequestAcceptedIssuesServiceCall extends scrum.client.core.AServiceCall {

    public  RequestAcceptedIssuesServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestAcceptedIssues(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestAcceptedIssues";
    }

}

