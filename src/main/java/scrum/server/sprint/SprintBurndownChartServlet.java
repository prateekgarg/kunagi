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
		String widthParam = req.getParameter("width");
		if (widthParam == null) widthParam = String.valueOf(ProjectOverviewWidget.CHART_WIDTH);
		String heightParam = req.getParameter("height");
		if (heightParam == null) heightParam = String.valueOf(ProjectOverviewWidget.CHART_HEIGHT);
		boolean isWorkChart = "workChart".equals(req.getParameter("chart"));
		boolean isEfficiencyChart = "efficiencyChart".equals(req.getParameter("chart"));
		boolean isAccomplishChart = "accomplishChart".equals(req.getParameter("chart"));
		String userNameParam = req.getParameter("userName");
		String userName = (userNameParam == null || userNameParam.isEmpty() || "null".equals(userNameParam)) ? null
				: userNameParam;

		Servlet.preventCaching(resp);
		resp.setContentType("image/png");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int width = Integer.parseInt(widthParam);
		int height = Integer.parseInt(heightParam);
		if (isWorkChart) {
			// team or user burned hours
			ScrumWebApplication.get().getUserBurndownChart().writeChart(out, sprintId, width, height, userName);
		} else if (isEfficiencyChart) {
			// initial / burned hours at closed tasks
			ScrumWebApplication.get().getEfficiencyChart().writeChart(out, sprintId, width, height);
		} else if (isAccomplishChart) {
			// burned hours per user
			ScrumWebApplication.get().getAccomplishChart().writeChart(out, sprintId, width, height);
		} else {
			// sprint burndown
			ScrumWebApplication.get().getBurndownChart().writeChart(out, sprintId, width, height);
		}

		resp.getOutputStream().write(out.toByteArray());
	}
}
