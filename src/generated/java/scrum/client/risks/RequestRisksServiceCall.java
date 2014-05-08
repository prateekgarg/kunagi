// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.risks;

public class RequestRisksServiceCall extends scrum.client.core.AServiceCall {

    public  RequestRisksServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestRisks(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestRisks";
    }

}

