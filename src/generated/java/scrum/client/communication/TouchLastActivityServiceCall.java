// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.communication;

public class TouchLastActivityServiceCall extends scrum.client.core.AServiceCall {

    public  TouchLastActivityServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().touchLastActivity(conversationNumber, callback);
    }

    @Override
    public boolean isDispensable() {
        return true;
    }

    @Override
    public String toString() {
        return "TouchLastActivity";
    }

}

