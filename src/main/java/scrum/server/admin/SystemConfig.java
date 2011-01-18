package scrum.server.admin;

public class SystemConfig extends GSystemConfig {

	@Override
	public boolean isVisibleFor(User user) {
		return true;
	}

	@Override
	public boolean isEditableBy(User user) {
		if (user == null) return false;
		return user.isAdmin();
	}

	@Override
	protected String prepareUrl(String url) {
		if (url != null && !url.endsWith("/")) url += "/";
		return super.prepareUrl(url);
	}

	@Override
	public void ensureIntegrity() {
		super.ensureIntegrity();
		if (!isDefaultUserPasswordSet()) setDefaultUserPassword(scrum.client.admin.User.INITIAL_PASSWORD);
		if (!isMaxFileSizeSet()) setMaxFileSize(20);
	}

}