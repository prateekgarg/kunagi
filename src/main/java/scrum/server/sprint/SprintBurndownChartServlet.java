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
package scrum.server.sprint;

import ilarkesto.webapp.Servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scrum.client.project.ProjectOverviewWidget;
import scrum.server.ScrumWebApplication;
import scrum.server.WebSession;
import scrum.server.common.AHttpServlet;

public class SprintBurndownChartServlet extends AHttpServlet {

	@Override
	protected void onRequest(HttpServletRequest req, HttpServletResponse resp, WebSession session) throws IOException {
		String sprintId = req.getParameter("sprintId");
		String width = req.getParameter("width");
		if (width == null) width = String.valueOf(ProjectOverviewWidget.CHART_WIDTH);
		String height = req.getParameter("height");
		if (height == null) height = String.valueOf(ProjectOverviewWidget.CHART_HEIGHT);

		Servlet.preventCaching(resp);
		resp.setContentType("image/png");

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		ScrumWebApplication.get().getBurndownChart().writeSprintBurndownChart(out, sprintId, Integer.parseInt(width),
			Integer.parseInt(height));

		resp.getOutputStream().write(out.toByteArray());
	}

}
