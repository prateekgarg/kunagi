/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.common;

import ilarkesto.base.PermissionDeniedException;
import ilarkesto.core.logging.Log;
import ilarkesto.persistence.AEntity;
import ilarkesto.webapp.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scrum.server.ScrumWebApplication;
import scrum.server.WebSession;
import scrum.server.project.Project;

public abstract class AHttpServlet extends HttpServlet {

	private static final Log LOG = Log.get(AHttpServlet.class);

	protected abstract void onRequest(HttpServletRequest req, HttpServletResponse resp, WebSession session)
			throws IOException;

	protected void onInit(ServletConfig config) {}

	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Servlet.preventCaching(resp);
		try {
			onRequest(req, resp, (WebSession) ScrumWebApplication.get().getWebSession(req));
		} catch (Throwable ex) {
			LOG.fatal("GET failed:", getClass().getName(), "->", ex);
		}
	}

	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Servlet.preventCaching(resp);
		try {
			onRequest(req, resp, (WebSession) ScrumWebApplication.get().getWebSession(req));
		} catch (Throwable ex) {
			LOG.fatal("POST failed:", getClass().getName(), "->", ex);
		}
	}

	@Override
	public final void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			onInit(config);
		} catch (Throwable ex) {
			LOG.fatal("Init failed:", getClass().getName(), "->", ex);
			throw new ServletException(ex);
		}
	}

	@Override
	public final void init() throws ServletException {
		super.init();
	}

	// --- helper ---

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
