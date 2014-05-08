// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.core;

public class RequestEntityServiceCall extends scrum.client.core.AServiceCall {

    private String entityId;

    public  RequestEntityServiceCall(String entityId) {
        this.entityId = entityId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestEntity(conversationNumber, entityId, callback);
    }

    @Override
    public String toString() {
        return "RequestEntity";
    }

}

