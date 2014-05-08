// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.core;

public class SleepServiceCall extends scrum.client.core.AServiceCall {

    private long millis;

    public  SleepServiceCall(long millis) {
        this.millis = millis;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().sleep(conversationNumber, millis, callback);
    }

    @Override
    public boolean isDispensable() {
        return true;
    }

    @Override
    public String toString() {
        return "Sleep";
    }

}

