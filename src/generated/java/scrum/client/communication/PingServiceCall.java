// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.communication;

public class PingServiceCall extends scrum.client.core.AServiceCall {

    public  PingServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().ping(conversationNumber, callback);
    }

    @Override
    public boolean isDispensable() {
        return true;
    }

    @Override
    public String toString() {
        return "Ping";
    }

}

