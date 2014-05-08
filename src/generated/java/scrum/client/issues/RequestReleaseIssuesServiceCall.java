// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.issues;

public class RequestReleaseIssuesServiceCall extends scrum.client.core.AServiceCall {

    private String releaseId;

    public  RequestReleaseIssuesServiceCall(String releaseId) {
        this.releaseId = releaseId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestReleaseIssues(conversationNumber, releaseId, callback);
    }

    @Override
    public String toString() {
        return "RequestReleaseIssues";
    }

}

