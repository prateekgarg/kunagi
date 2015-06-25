// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.core;

public class ChangePropertiesServiceCall extends scrum.client.core.AServiceCall {

    private String entityId;

    private java.util.Map<String, String> properties;

    public  ChangePropertiesServiceCall(String entityId, java.util.Map<String, String> properties) {
        this.entityId = entityId;
        this.properties = properties;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().changeProperties(conversationNumber, entityId, properties, callback);
    }

    @Override
    public boolean isDispensable() {
        return ilarkesto.core.scope.Scope.get().getComponent(scrum.client.Dao.class).getEntity(entityId) instanceof scrum.client.admin.ProjectUserConfig && (properties.containsKey("selectedEntitysIds") || properties.containsKey("richtextAutosaveText") || properties.containsKey("richtextAutosaveField") || properties.containsKey("online"));
    }

    @Override
    public String toString() {
        return "ChangeProperties";
    }

}

