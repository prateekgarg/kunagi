// ----------> GENERATED FILE - DON'T TOUCH! <----------

// generator: ilarkesto.mda.legacy.generator.GwtServiceCallGenerator










package scrum.client.core;

import java.util.*;

@com.google.gwt.user.client.rpc.RemoteServiceRelativePath("scrum")
public class CreateEntityServiceCall
            extends ilarkesto.gwt.client.AServiceCall<scrum.client.DataTransferObject> {

    private static scrum.client.ScrumServiceAsync service;

    java.lang.String type;
    java.util.Map<String, String> properties;

    public CreateEntityServiceCall(java.lang.String type, java.util.Map<String, String> properties) {
        this.type = type;
        this.properties = properties;
    }

    @Override
    protected synchronized void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        if (service==null) {
            service = (scrum.client.ScrumServiceAsync) com.google.gwt.core.client.GWT.create(scrum.client.ScrumService.class);
            initializeService(service, "scrum");
        }
        service.createEntity(conversationNumber, type, properties, callback);
    }

    @Override
    public String toString() {
        return "createEntity";
    }

}