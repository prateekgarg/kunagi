/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package scrum.server.admin;

import ilarkesto.base.Utl;
import ilarkesto.core.base.Str;
import ilarkesto.core.time.DateAndTime;
import ilarkesto.core.time.Tm;
import ilarkesto.ui.web.HtmlRenderer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scrum.client.admin.SystemMessage;
import scrum.server.WebSession;
import scrum.server.common.AHttpServlet;

public class ShutdownServlet extends AHttpServlet {

	private boolean shutdownInitiated;

	@Override
	protected void onRequest(HttpServletRequest req, HttpServletResponse resp, WebSession session) throws IOException {
		tokenLogin(req, resp, session);

		User user = session.getUser();
		if (user == null) {
			redirectToLogin(req, resp, session);
			return;
		}

		if (!user.isAdmin()) {
			resp.sendError(403);
			return;
		}

		if (!shutdownInitiated) {
			shutdownInitiated = true;
			String sDelay = req.getParameter("delay");
			if (Str.isBlank(sDelay)) {
				webApplication.updateSystemMessage(new SystemMessage("Service is going down for maintenance now.",
						new DateAndTime(System.currentTimeMillis()), true));
				webApplication.shutdown();
			} else {
				final long delay = Long.parseLong(sDelay) * Tm.MINUTE;
				new Thread() {

					@Override
					public void run() {
						webApplication.updateSystemMessage(new SystemMessage("Service is going down for maintenance.",
								new DateAndTime(System.currentTimeMillis() + delay), true));
						if (delay > 0) Utl.sleep(delay);
						webApplication.shutdown();
					}
				}.start();
			}

		}

		HtmlRenderer html = createDefaultHtmlWithHeader(resp, "Shutdown initiated");
		html.startBODY();
		html.H1("Shutdown initiated");
		html.startP();
		html.text("This page will not refresh.");
		html.endP();
		html.endBODY();
		html.endHTML();
		html.flush();
	}
}
