/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.common;

import ilarkesto.base.PermissionDeniedException;
import ilarkesto.base.Str;
import ilarkesto.base.time.DateAndTime;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.AEntity;
import ilarkesto.webapp.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scrum.client.ApplicationInfo;
import scrum.client.ScrumGwtApplication;
import scrum.server.KunagiRootConfig;
import scrum.server.ScrumWebApplication;
import scrum.server.WebSession;
import scrum.server.admin.SystemConfig;
import scrum.server.admin.User;
import scrum.server.admin.UserDao;
import scrum.server.project.Project;

public abstract class AHttpServlet extends HttpServlet {

	protected static final int LOGIN_TOKEN_COOKIE_MAXAGE = 518400; // 6 days

	private static final Log log = Log.get(AHttpServlet.class);

	protected static ScrumWebApplication webApplication;
	protected KunagiRootConfig config;
	protected ApplicationInfo applicationInfo;
	protected SystemConfig systemConfig;
	protected UserDao userDao;

	protected abstract void onRequest(HttpServletRequest req, HttpServletResponse resp, WebSession session)
			throws IOException;

	protected void onInit(ServletConfig config) {}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Servlet.preventCaching(resp);
		try {
			onRequest(req, resp, (WebSession) ScrumWebApplication.get().getWebSession(req));
		} catch (Throwable ex) {
			log.fatal("GET failed:", getClass().getName(), "->", ex);
		}
	}

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Servlet.preventCaching(resp);
		try {
			onRequest(req, resp, (WebSession) ScrumWebApplication.get().getWebSession(req));
		} catch (Throwable ex) {
			log.fatal("POST failed:", getClass().getName(), "->", ex);
		}
	}

	@Override
	public final void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		try {
			webApplication = ScrumWebApplication.get(servletConfig);
			config = webApplication.getConfig();
			applicationInfo = webApplication.getApplicationInfo();
			systemConfig = webApplication.getSystemConfig();
			userDao = webApplication.getUserDao();
			onInit(servletConfig);
		} catch (Throwable ex) {
			log.fatal("Init failed:", getClass().getName(), "->", ex);
			throw new ServletException(ex);
		}
	}

	@Override
	public final void init() throws ServletException {
		super.init();
	}

	// --- helper ---

	protected boolean tokenLogin(HttpServletRequest req, HttpServletResponse resp, WebSession session)
			throws IOException {
		String loginToken = Servlet.getCookieValue(req, ScrumGwtApplication.LOGIN_TOKEN_COOKIE);
		if (!Str.isBlank(loginToken)) {
			User user = userDao.getUserByLoginToken(loginToken);
			if (user != null) {
				user.setLastLoginDateAndTime(DateAndTime.now());
				session.setUser(user);
				Servlet.setCookie(resp, ScrumGwtApplication.LOGIN_TOKEN_COOKIE, user.getLoginToken(),
					LOGIN_TOKEN_COOKIE_MAXAGE);
				return true;
			}
		}
		return false;
	}

	protected void redirectToLogin(HttpServletRequest req, HttpServletResponse resp, WebSession session)
			throws IOException {
		String url = "login.html";
		String token = Str.cutFrom(req.getRequestURI(), "#");
		if (!Str.isBlank(token)) url += "?historyToken=" + Str.encodeUrlParameter(token);
		url = webApplication.createUrl(url);
		log.debug("Redirecting to", url);
		resp.sendRedirect(url);
	}

	public static <E extends AEntity> E getEntityByParameter(HttpServletRequest req, Class<E> type) {
		return getEntityByParameter(req, "entityId", type);
	}

	public static <E extends AEntity> E getEntityByParameter(HttpServletRequest req, String parameterName, Class<E> type) {
		String id = req.getParameter(parameterName);
		if (id == null) throw new RuntimeException(parameterName + "==null");
		return (E) ScrumWebApplication.get().getDaoService().getById(id);
	}

	public static Project getProject(WebSession session, HttpServletRequest req) {
		Project project = getEntityByParameter(req, "projectId", Project.class);
		if (!project.isVisibleFor(session.getUser())) throw new PermissionDeniedException();
		return project;
	}

}
