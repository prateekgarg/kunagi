package scrum.client.admin;

import ilarkesto.core.scope.Scope;

import java.util.List;
import java.util.Map;

public class ProjectUserConfig extends GProjectUserConfig {

	public ProjectUserConfig() {}

	public ProjectUserConfig(Map data) {
		super(data);
	}

	public boolean addSelectedEntityId(String entityId) {
		List<String> ids = getSelectedEntitysIds();
		if (ids.contains(entityId)) return false;
		ids.add(entityId);
		setSelectedEntitysIds(ids);
		return true;
	}

	public boolean removeSelectedEntityId(String entityId) {
		List<String> ids = getSelectedEntitysIds();
		if (!ids.contains(entityId)) return false;
		ids.remove(entityId);
		setSelectedEntitysIds(ids);
		return true;
	}

	@Override
	public boolean isMisconductsEditable() {
		return getProject().isScrumMaster(Scope.get().getComponent(Auth.class).getUser());
	}

	@Override
	public String toString() {
		return getProject() + " " + getUser();
	}

}
