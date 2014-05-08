// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class UpdateSystemMessageServiceCall extends scrum.client.core.AServiceCall {

    private scrum.client.admin.SystemMessage systemMessage;

    public  UpdateSystemMessageServiceCall(scrum.client.admin.SystemMessage systemMessage) {
        this.systemMessage = systemMessage;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().updateSystemMessage(conversationNumber, systemMessage, callback);
    }

    @Override
    public String toString() {
        return "UpdateSystemMessage";
    }

}

