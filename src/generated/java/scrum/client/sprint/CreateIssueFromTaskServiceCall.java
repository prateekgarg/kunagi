// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class CreateIssueFromTaskServiceCall extends scrum.client.core.AServiceCall {

    private String taskId;

    public  CreateIssueFromTaskServiceCall(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().createIssueFromTask(conversationNumber, taskId, callback);
    }

    @Override
    public String toString() {
        return "CreateIssueFromTask";
    }

}

