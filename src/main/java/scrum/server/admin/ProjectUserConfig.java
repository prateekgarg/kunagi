package scrum.server.admin;

import ilarkesto.base.time.DateAndTime;

public class ProjectUserConfig extends GProjectUserConfig {

	public void touch() {
		setLastActivityDateAndTime(DateAndTime.now());
		setOnline(true);
	}

	public void reset() {
		setOnline(false);
		setSelectedEntitysIds(null);
	}

	@Override
	public boolean isVisibleFor(User user) {
		return getProject().isVisibleFor(user);
	}

	public boolean isEditableBy(User user) {
		return getProject().isEditableBy(user);
	}

	@Override
	public String toString() {
		return getProject() + " " + getUser();
	}

}