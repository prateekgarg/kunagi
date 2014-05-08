// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.issues;

public class SendIssueReplyEmailServiceCall extends scrum.client.core.AServiceCall {

    private String issueId;

    private String from;

    private String to;

    private String subject;

    private String text;

    public  SendIssueReplyEmailServiceCall(String issueId, String from, String to, String subject, String text) {
        this.issueId = issueId;
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().sendIssueReplyEmail(conversationNumber, issueId, from, to, subject, text, callback);
    }

    @Override
    public String toString() {
        return "SendIssueReplyEmail";
    }

}

