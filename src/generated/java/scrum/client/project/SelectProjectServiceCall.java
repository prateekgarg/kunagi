// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class SelectProjectServiceCall extends scrum.client.core.AServiceCall {

    private String projectId;

    public  SelectProjectServiceCall(String projectId) {
        this.projectId = projectId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().selectProject(conversationNumber, projectId, callback);
    }

    @Override
    public String toString() {
        return "SelectProject";
    }

}

