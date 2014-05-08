// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class UpdateProjectHomepageServiceCall extends scrum.client.core.AServiceCall {

    public  UpdateProjectHomepageServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().updateProjectHomepage(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "UpdateProjectHomepage";
    }

}

