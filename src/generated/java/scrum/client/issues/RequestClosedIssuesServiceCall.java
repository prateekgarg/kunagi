// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.issues;

public class RequestClosedIssuesServiceCall extends scrum.client.core.AServiceCall {

    public  RequestClosedIssuesServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestClosedIssues(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestClosedIssues";
    }

}

