// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.core;

public class CreateEntityServiceCall extends scrum.client.core.AServiceCall {

    private String type;

    private java.util.Map properties;

    public  CreateEntityServiceCall(String type, java.util.Map properties) {
        this.type = type;
        this.properties = properties;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().createEntity(conversationNumber, type, properties, callback);
    }

    @Override
    public String toString() {
        return "CreateEntity";
    }

}

