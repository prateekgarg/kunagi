package scrum.server;

import ilarkesto.base.Sys;
import ilarkesto.base.Utl;
import ilarkesto.core.logging.Log;
import ilarkesto.io.IO;
import ilarkesto.properties.APropertiesStore;
import ilarkesto.properties.FilePropertiesStore;

import java.io.File;
import java.util.Properties;

public class KunagiRootConfig {

	private static Log log = Log.get(KunagiRootConfig.class);

	private APropertiesStore props;

	private String dataPath;

	public KunagiRootConfig() {
		this(new File(determineUsedDataPath() + "/config.properties"), determineDefaultConfigFile());
	}

	public KunagiRootConfig(File configFile, File defaultsFile) {
		log.info("\n\n     CONFIGURATION FILE:", configFile.getAbsolutePath(), "\n\n");
		props = new FilePropertiesStore(configFile, true).setLabel("Kunag Configuration");
		if (defaultsFile != null && defaultsFile.exists()) {
			log.info("\n\n     Including configuration defaults from:", defaultsFile.getAbsolutePath(), "\n\n");
			Properties defaults = IO.loadProperties(defaultsFile, IO.UTF_8);
			props.setDefaults(defaults);
		}
	}

	public String getDataPath() {
		if (dataPath == null) {
			dataPath = props.get("data.path");
			if (dataPath == null) {
				dataPath = determineUsedDataPath();
			} else {
				dataPath = new File(dataPath).getAbsolutePath();
			}
			props.set("data.path", dataPath);
		}
		return dataPath;
	}

	private static File determineDefaultConfigFile() {
		return Sys.isWindows() ? new File(Sys.getUsersHomePath() + "/kunagi.properties") : new File(
				"/etc/kunagi.properties");
	}

	private static String determineUsedDataPath() {
		if (Sys.isDevelopmentMode()) return new File("runtimedata").getAbsolutePath();
		File legacyDataDir = determineLegacyDataDir();
		return legacyDataDir != null && legacyDataDir.exists() ? legacyDataDir.getAbsolutePath()
				: determineDefaultDataPath();
	}

	private static String determineDefaultDataPath() {
		String path = Sys.isWindows() ? Sys.getUsersHomePath() + "/Kunagi" : Sys.getWorkDir().getAbsolutePath()
				+ "/webapps/kunagi";
		return new File(path).getAbsolutePath();
	}

	private static File determineLegacyDataDir() {
		return Utl.getFirstExistingFile(Sys.getUsersHomePath() + "/webapp-data/kunagi", Sys.getUsersHomePath()
				+ "/webapps/kunagi", Sys.getWorkDir() + "/webapp-data/kunagi", Sys.getWorkDir() + "/webapps/kunagi");
	}

	public String getUrl() {
		return props.get("url");
	}

	public void setUrl(String url) {
		props.set("url", url);
	}

	public String getFileRepositoryPath() {
		return props.get("fileRepository.path", getDataPath() + "/files");
	}

	public boolean isStartupDelete() {
		return props.getBoolean("startup.delete", false);
	}

	public boolean isDeleteOldProjects() {
		return props.getBoolean("deleteOldProjects", false);
	}

	public boolean isDeleteDisabledUsers() {
		return props.getBoolean("deleteDisabledUsers", false);
	}

	public boolean isDisableUsersWithUnverifiedEmails() {
		return props.getBoolean("disableUsersWithUnverifiedEmails", false);
	}

	public boolean isDisableInactiveUsers() {
		return props.getBoolean("disableInactiveUsers", false);
	}

	public boolean isStageIntegration() {
		return props.getBoolean("stage.integration", false);
	}

	public String getInitialPassword() {
		return props.get("initialPassword", scrum.client.admin.User.INITIAL_PASSWORD);
	}

	public boolean isLoggingDebug() {
		return props.getBoolean("logging.debug", false);
	}

	public String getHttpProxyHost() {
		return props.get("http.proxy.host");
	}

	public int getHttpProxyPort() {
		return props.getInt("http.proxy.port", 8080);
	}

}
