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

	private String webappName;
	private String dataPath;

	public KunagiRootConfig(File configFile, File defaultsFile) {
		this(configFile, defaultsFile, "kunagi");
	}

	public KunagiRootConfig(String webappName) {
		this(new File(determineUsedDataPath(webappName) + "/config.properties"),
				determineDefaultConfigFile(webappName), webappName);
	}

	private KunagiRootConfig(File configFile, File defaultsFile, String webappName) {
		this.webappName = webappName;
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
				dataPath = determineUsedDataPath(webappName);
			} else {
				dataPath = new File(dataPath).getAbsolutePath();
			}
			props.set("data.path", dataPath);
		}
		return dataPath;
	}

	private static File determineDefaultConfigFile(String webappName) {
		return Sys.isWindows() ? new File(Sys.getUsersHomePath() + "/" + webappName + ".properties") : new File("/etc/"
				+ webappName + ".properties");
	}

	private static String determineUsedDataPath(String webappName) {
		if (Sys.isDevelopmentMode()) return new File("runtimedata").getAbsolutePath();
		File legacyDataDir = determineLegacyDataDir(webappName);
		return legacyDataDir != null && legacyDataDir.exists() ? legacyDataDir.getAbsolutePath()
				: determineDefaultDataPath(webappName);
	}

	private static String determineDefaultDataPath(String webappName) {
		String path = Sys.isWindows() ? Sys.getUsersHomePath() + "/" + webappName : Sys.getWorkDir().getAbsolutePath()
				+ "/webapps/" + webappName;
		return new File(path).getAbsolutePath();
	}

	private static File determineLegacyDataDir(String webappName) {
		return Utl.getFirstExistingFile(Sys.getUsersHomePath() + "/webapp-data/" + webappName, Sys.getUsersHomePath()
				+ "/webapps/" + webappName, Sys.getWorkDir() + "/webapp-data/" + webappName, Sys.getWorkDir()
				+ "/webapps/" + webappName);
	}

	public String getUrl() {
		return props.get("url", Sys.isDevelopmentMode() ? "http://localhost:8888/" : null);
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

	public boolean isShowRelease() {
		return props.getBoolean("showRelease", Sys.isDevelopmentMode());
	}

	public boolean isCreateTestData() {
		return props.getBoolean("createTestData", Sys.isDevelopmentMode());
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
