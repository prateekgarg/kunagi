package scrum.server.admin;

public class ProjectUserConfig extends GProjectUserConfig {

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