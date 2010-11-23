package scrum.client;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ApplicationInfo implements Serializable, IsSerializable {

	private String name;
	private String release;
	private String build;
	private boolean defaultAdminPassword;
	private String currentRelease;

	public ApplicationInfo(String name, String release, String build, boolean defaultAdminPassword,
			String currentRelease) {
		this.name = name;
		this.release = release;
		this.build = build;
		this.defaultAdminPassword = defaultAdminPassword;
		this.currentRelease = currentRelease;
	}

	protected ApplicationInfo() {}

	public boolean isNewReleaseAvailable() {
		if (currentRelease == null) return false;
		if (release.startsWith("dev")) return false;
		return !currentRelease.equals(release);
	}

	public boolean isDefaultAdminPassword() {
		return defaultAdminPassword;
	}

	public String getRelease() {
		return release;
	}

	public String getCurrentRelease() {
		return currentRelease;
	}

	public String getBuild() {
		return build;
	}

	public boolean isProductionStage() {
		return !release.startsWith("dev[");
	}

	public String getVersionDescription() {
		return name + " " + release + " | Build " + build;
	}

	@Override
	public String toString() {
		return getVersionDescription();
	}

}
