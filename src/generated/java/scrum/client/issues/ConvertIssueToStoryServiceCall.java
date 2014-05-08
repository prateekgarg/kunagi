// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.issues;

public class ConvertIssueToStoryServiceCall extends scrum.client.core.AServiceCall {

    private String issueId;

    public  ConvertIssueToStoryServiceCall(String issueId) {
        this.issueId = issueId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().convertIssueToStory(conversationNumber, issueId, callback);
    }

    @Override
    public String toString() {
        return "ConvertIssueToStory";
    }

}

