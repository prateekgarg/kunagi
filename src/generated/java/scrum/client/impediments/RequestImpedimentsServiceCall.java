// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.impediments;

public class RequestImpedimentsServiceCall extends scrum.client.core.AServiceCall {

    public  RequestImpedimentsServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestImpediments(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "RequestImpediments";
    }

}

