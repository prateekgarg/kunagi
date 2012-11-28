// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class PullIssueToSprintServiceCall extends scrum.client.core.AServiceCall {

    private String issueId;

    public  PullIssueToSprintServiceCall(String issueId) {
        this.issueId = issueId;
    }

    public void execute(Runnable returnHandler) {
        serviceCaller.onServiceCall(this);
        serviceCaller.getService().pullIssueToSprint(serviceCaller.getConversationNumber(), issueId, new DefaultCallback(this, returnHandler));
    }

    @Override
    public String toString() {
        return "PullIssueToSprint";
    }

}

