package scrum.server.common;

import ilarkesto.base.Str;
import ilarkesto.core.logging.Log;
import ilarkesto.io.IO;
import ilarkesto.ui.web.HtmlRenderer;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scrum.client.ApplicationInfo;
import scrum.server.KunagiRootConfig;
import scrum.server.ScrumWebApplication;
import scrum.server.WebSession;
import scrum.server.admin.SystemConfig;

public class StartServlet extends AHttpServlet {

	private static Log log = Log.get(StartServlet.class);

	private static ScrumWebApplication webApplication;
	private static boolean first = true;

	private KunagiRootConfig config;
	private ApplicationInfo applicationInfo;

	@Override
	protected void onRequest(HttpServletRequest req, HttpServletResponse resp, WebSession session) throws IOException {
		SystemConfig systemConfig = webApplication.getSystemConfig();
		if (session.getUser() == null) {
			String requestUrl = req.getRequestURL().toString();
			requestUrl = Str.removeSuffix(requestUrl, "index.html");
			if (first) {
				first = false;
				if (!systemConfig.isUrlSet()) systemConfig.setUrl(requestUrl);
			}
			String url = "login.html";
			String token = Str.cutFrom(req.getRequestURI(), "#");
			if (!Str.isBlank(token)) url += "?historyToken=" + Str.encodeUrlParameter(token);
			url = webApplication.createUrl(url);
			log.debug("Redirecting to", url);
			resp.sendRedirect(url);
			return;
		}

		String charset = IO.UTF_8;
		resp.setContentType("text/html");

		HtmlRenderer html = new HtmlRenderer(resp.getOutputStream(), charset);
		html.startHTMLstandard();

		String title = "Kunagi";
		if (config.isShowRelease()) title += " " + applicationInfo.getRelease();
		html.startHEAD(title, "EN");
		html.META("X-UA-Compatible", "chrome=1");
		html.LINKfavicon();
		html.SCRIPTjavascript("scrum.ScrumGwtApplication/scrum.ScrumGwtApplication.nocache.js", null);
		html.SCRIPTjavascript("codemirror/js/codemirror.js", null);
		html.endHEAD();

		html.startBODY();
		html.comment(applicationInfo.toString());
		String analyticsId = systemConfig.getGoogleAnalyticsId();
		if (analyticsId != null) html.googleAnalytics(analyticsId);
		html.endBODY();

		html.endHTML();
		html.flush();
	}

	@Override
	protected void onInit(ServletConfig servletConfig) {
		super.onInit(servletConfig);

		webApplication = ScrumWebApplication.get(servletConfig);

		config = webApplication.getConfig();
		applicationInfo = webApplication.getApplicationInfo();
	}

}
