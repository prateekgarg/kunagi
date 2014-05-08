// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class SendTestEmailServiceCall extends scrum.client.core.AServiceCall {

    public  SendTestEmailServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().sendTestEmail(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "SendTestEmail";
    }

}

