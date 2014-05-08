// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.core;

public class RequestEntityByReferenceServiceCall extends scrum.client.core.AServiceCall {

    private String reference;

    public  RequestEntityByReferenceServiceCall(String reference) {
        this.reference = reference;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestEntityByReference(conversationNumber, reference, callback);
    }

    @Override
    public String toString() {
        return "RequestEntityByReference";
    }

}

