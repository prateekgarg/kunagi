// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class CreateExampleProjectServiceCall extends scrum.client.core.AServiceCall {

    public  CreateExampleProjectServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().createExampleProject(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "CreateExampleProject";
    }

}

