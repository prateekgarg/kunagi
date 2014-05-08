// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.journal;

public class RequestChangesServiceCall extends scrum.client.core.AServiceCall {

    private String parentId;

    public  RequestChangesServiceCall(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestChanges(conversationNumber, parentId, callback);
    }

    @Override
    public String toString() {
        return "RequestChanges";
    }

}

