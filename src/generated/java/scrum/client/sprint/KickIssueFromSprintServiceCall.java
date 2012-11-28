// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class KickIssueFromSprintServiceCall extends scrum.client.core.AServiceCall {

    private String issueId;

    public  KickIssueFromSprintServiceCall(String issueId) {
        this.issueId = issueId;
    }

    public void execute(Runnable returnHandler) {
        serviceCaller.onServiceCall(this);
        serviceCaller.getService().kickIssueFromSprint(serviceCaller.getConversationNumber(), issueId, new DefaultCallback(this, returnHandler));
    }

    @Override
    public String toString() {
        return "KickIssueFromSprint";
    }

}

