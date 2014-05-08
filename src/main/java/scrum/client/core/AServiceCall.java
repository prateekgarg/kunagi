package scrum.client.core;

import ilarkesto.core.scope.Scope;
import scrum.client.Dao;
import scrum.client.DataTransferObject;
import scrum.client.ScrumGwtApplication;
import scrum.client.ScrumService;
import scrum.client.ScrumServiceAsync;
import scrum.client.communication.ServerDataReceivedEvent;

public abstract class AServiceCall extends ilarkesto.gwt.client.AServiceCall<DataTransferObject> {

	private static ScrumServiceAsync scrumService;

	protected final ScrumServiceAsync getService() {
		if (scrumService == null) {
			scrumService = com.google.gwt.core.client.GWT.create(ScrumService.class);
			((com.google.gwt.user.client.rpc.ServiceDefTarget) scrumService)
					.setServiceEntryPoint(com.google.gwt.core.client.GWT.getModuleBaseURL() + "scrum");
		}
		return scrumService;
	}

	@Override
	protected void onCallbackSuccess(DataTransferObject data) {
		super.onCallbackSuccess(data);
		Scope.get().getComponent(Dao.class).handleDataFromServer(data);

		ScrumGwtApplication app = ScrumGwtApplication.get();
		if (data.applicationInfo != null) {
			app.applicationInfo = data.applicationInfo;
			log.debug("applicationInfo:", data.applicationInfo);
			// Scope.get().putComponent(data.applicationInfo);
		} else {
			assert app.applicationInfo != null;
		}

		new ServerDataReceivedEvent(data).fireInCurrentScope();
	}
}
