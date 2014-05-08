// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.collaboration;

public class RequestCommentsServiceCall extends scrum.client.core.AServiceCall {

    private String parentId;

    public  RequestCommentsServiceCall(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestComments(conversationNumber, parentId, callback);
    }

    @Override
    public String toString() {
        return "RequestComments";
    }

}

