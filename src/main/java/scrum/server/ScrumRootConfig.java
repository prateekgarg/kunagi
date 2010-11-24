package scrum.server;

import ilarkesto.base.Sys;
import ilarkesto.base.Utl;
import ilarkesto.properties.APropertiesStore;
import ilarkesto.properties.FilePropertiesStore;

import java.io.File;

public class ScrumRootConfig {

	private String dataPath;

	private APropertiesStore userProperties;
	private String applicationDataDir;

	public ScrumRootConfig(String applicationDataDir) {
		this.applicationDataDir = applicationDataDir;
		userProperties = new FilePropertiesStore(applicationDataDir + "/config.properties", true);
	}

	public String getDataPath() {
		if (dataPath == null) {
			dataPath = userProperties.get("data.path");
			if (dataPath == null) {
				File legacyDataDir = getLegacyDataDir();
				if (legacyDataDir.exists()) {
					dataPath = legacyDataDir.getAbsolutePath();
					userProperties.set("data.path", dataPath);
				} else {
					dataPath = getDefaultDataPath();
				}
			}
		}
		return dataPath;
	}

	private String getDefaultDataPath() {
		return Sys.getWorkDir() + "/webapps/kunagi";
	}

	private File getLegacyDataDir() {
		return Utl.getFirstExistingFile(Sys.getUsersHomePath() + "/webapp-data/kunagi", Sys.getUsersHomePath()
				+ "/webapps/kunagi", Sys.getWorkDir() + "/webapp-data/kunagi", Sys.getWorkDir() + "/webapps/kunagi");
	}

	public String getUrl() {
		return userProperties.get("url");
	}

	public void setUrl(String url) {
		userProperties.set("url", url);
	}

	public String getFileRepositoryPath() {
		return userProperties.get("fileRepository.path", applicationDataDir + "/files");
	}

	public boolean isStartupDelete() {
		return userProperties.getBoolean("startup.delete", false);
	}

	public boolean isDeleteOldProjects() {
		return userProperties.getBoolean("deleteOldProjects", false);
	}

	public boolean isDeleteDisabledUsers() {
		return userProperties.getBoolean("deleteDisabledUsers", false);
	}

	public boolean isDisableUsersWithUnverifiedEmails() {
		return userProperties.getBoolean("disableUsersWithUnverifiedEmails", false);
	}

	public boolean isDisableInactiveUsers() {
		return userProperties.getBoolean("disableInactiveUsers", false);
	}

	public boolean isStageIntegration() {
		return userProperties.getBoolean("stage.integration", false);
	}

	public String getInitialPassword() {
		return userProperties.get("initialPassword", scrum.client.admin.User.INITIAL_PASSWORD);
	}

	public boolean isLoggingDebug() {
		return userProperties.getBoolean("logging.debug", false);
	}

	public String getHttpProxyHost() {
		return userProperties.get("http.proxy.host");
	}

	public int getHttpProxyPort() {
		return userProperties.getInt("http.proxy.port", 8080);
	}

}
