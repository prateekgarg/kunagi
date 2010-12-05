package scrum.client.admin;

import ilarkesto.core.base.Str;

public class TestLdapAction extends GTestLdapAction {

	@Override
	public String getLabel() {
		return "Test LDAP";
	}

	@Override
	public boolean isExecutable() {
		SystemConfig config = getDao().getSystemConfig();
		if (Str.isBlank(config.getLdapUrl())) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		new TestLdapServiceCall().execute();
	}

}