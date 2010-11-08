package scrum.client.admin;

import ilarkesto.core.base.Utl;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.DateAndTime;
import ilarkesto.gwt.client.TimePeriod;

import java.util.ArrayList;
import java.util.Map;

public class ProjectUserConfig extends GProjectUserConfig {

	public ProjectUserConfig() {}

	public ProjectUserConfig(Map data) {
		super(data);
	}

	public boolean isIdle() {
		if (!isOnline()) return false;
		DateAndTime time = getLastActivityDateAndTime();
		if (time == null) return true;
		TimePeriod idle = time.getPeriodToNow();
		return (idle.toSeconds() > 30);
	}

	public String getIdleTimeAsString() {
		TimePeriod idle = getIdleTime();
		return idle == null ? "-" : idle.toShortestString();
	}

	public TimePeriod getIdleTime() {
		if (!isOnline()) return null;
		DateAndTime time = getLastActivityDateAndTime();
		if (time == null) return null;
		TimePeriod idle = time.getPeriodToNow();
		if (idle.toSeconds() < 10) return null;
		return idle;
	}

	public boolean addSelectedEntityId(String entityId) {
		// List<String> ids = getSelectedEntitysIds();
		// if (ids.contains(entityId)) return false;
		// ids.add(entityId);
		// setSelectedEntitysIds(ids);
		setSelectedEntitysIds(Utl.toList(entityId));
		return true;
	}

	public boolean removeSelectedEntityId(String entityId) {
		// List<String> ids = getSelectedEntitysIds();
		// if (!ids.contains(entityId)) return false;
		// ids.remove(entityId);
		// setSelectedEntitysIds(ids);
		setSelectedEntitysIds(new ArrayList<String>(0));
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
