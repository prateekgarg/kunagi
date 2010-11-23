package scrum.client;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class ApplicationInfo implements Serializable, IsSerializable {

	private String name;
	private String release;
	private String build;
	private boolean defaultAdminPassword;
	private String currentRelease;
	private String dataPath;

	public ApplicationInfo(String name, String release, String build, boolean defaultAdminPassword,
			String currentRelease, String dataPath) {
		this.name = name;
		this.release = release;
		this.build = build;
		this.defaultAdminPassword = defaultAdminPassword;
		this.currentRelease = currentRelease;
		this.dataPath = dataPath;
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

	public String getDataPath() {
		return dataPath;
	}

	@Override
	public String toString() {
		return getVersionDescription();
	}

}
