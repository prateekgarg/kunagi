// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class CloseProjectServiceCall extends scrum.client.core.AServiceCall {

    public  CloseProjectServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().closeProject(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "CloseProject";
    }

}

