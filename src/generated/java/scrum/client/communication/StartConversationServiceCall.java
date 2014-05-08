// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.communication;

public class StartConversationServiceCall extends scrum.client.core.AServiceCall {

    public  StartConversationServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().startConversation(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "StartConversation";
    }

}

