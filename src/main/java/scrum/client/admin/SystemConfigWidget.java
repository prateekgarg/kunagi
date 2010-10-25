package scrum.client.admin;

import ilarkesto.gwt.client.ButtonWidget;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.ScrumGwt;
import scrum.client.common.AScrumWidget;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class SystemConfigWidget extends AScrumWidget {

	@Override
	protected Widget onInitialization() {
		SystemConfig config = getDao().getSystemConfig();

		PagePanel page = new PagePanel();

		page.addHeader("Login Page");
		TableBuilder tbLogin = ScrumGwt.createFieldTable();
		tbLogin.addFieldRow("Custom Logo", config.getLoginPageLogoUrlModel());
		tbLogin.addFieldRow("Login Message", config.getLoginPageMessageModel());
		tbLogin.addFieldRow("Register Message", config.getRegisterPageMessageModel());
		tbLogin.addFieldRow("Disable OpenID", config.getOpenIdDisabledModel());
		// tbMessages.addFieldRow("About Page", config.getAboutPageMessageModel());
		page.addSection(tbLogin.createTable());

		page.addHeader("Installation");
		TableBuilder tbKunagi = ScrumGwt.createFieldTable();
		tbKunagi.addFieldRow("Public URL", config.getUrlModel());
		tbKunagi.addFieldRow("Disable registration page", config.getRegistrationDisabledModel());
		tbKunagi.addFieldRow("Disable project creation", config.getProjectCreationDisabledModel());
		tbKunagi.addFieldRow("Users email is mandatory", config.getUserEmailMandatoryModel());
		tbKunagi.addFieldRow("Default user password", config.getDefaultUserPasswordModel());
		tbKunagi.addFieldRow("Check for updates", config.getVersionCheckEnabledModel());
		page.addSection(tbKunagi.createTable());

		page.addHeader("Email", new ButtonWidget(new SendTestEmailAction()));
		TableBuilder tbEmail = ScrumGwt.createFieldTable();
		tbEmail.addFieldRow("SMTP Server", config.getSmtpServerModel());
		tbEmail.addFieldRow("SMTP Port", config.getSmtpPortModel());
		tbEmail.addFieldRow("SMTP TLS", config.getSmtpTlsModel());
		tbEmail.addFieldRow("SMTP User", config.getSmtpUserModel());
		tbEmail.addFieldRow("SMTP Password", config.getSmtpPasswordModel());
		tbEmail.addFieldRow("Sender email", config.getSmtpFromModel());
		tbEmail.addFieldRow("Administrator email", config.getAdminEmailModel());
		page.addSection(tbEmail.createTable());

		page.addHeader("Google Integration");
		TableBuilder tbGoogle = ScrumGwt.createFieldTable();
		tbGoogle.addFieldRow("Analytics Id", config.getGoogleAnalyticsIdModel());
		page.addSection(tbGoogle.createTable());

		return page;
	}
}
