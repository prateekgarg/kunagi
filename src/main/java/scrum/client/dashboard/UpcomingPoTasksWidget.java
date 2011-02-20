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
package scrum.client.dashboard;

import java.util.Collections;
import java.util.List;

import scrum.client.common.AScrumWidget;
import scrum.client.issues.Issue;
import scrum.client.project.Project;
import scrum.client.project.Requirement;
import scrum.client.sprint.Sprint;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class UpcomingPoTasksWidget extends AScrumWidget {

	private HTML html;

	@Override
	protected Widget onInitialization() {
		html = new HTML();
		return html;
	}

	@Override
	protected void onUpdate() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div class='UpcomingTasksWidget'>");

		Project project = getCurrentProject();

		List<Issue> fixedBugs = project.getFixedBugs();
		Collections.sort(fixedBugs, project.getIssuesOrderComparator());
		if (!fixedBugs.isEmpty()) {
			sb.append("Fixed bugs to review:");
			sb.append("<ul>");
			for (Issue issue : fixedBugs) {
				sb.append("<li>");
				sb.append(issue.toHtml());
				sb.append("</li>");
			}
			sb.append("</ul>");
		}

		Sprint sprint = project.getCurrentSprint();
		List<Requirement> decidableRequirements = sprint.getDecidableUndecidedRequirements();
		Collections.sort(decidableRequirements, sprint.getRequirementsOrderComparator());
		if (!decidableRequirements.isEmpty()) {
			sb.append("Completed Stories to review:");
			sb.append("<ul>");
			for (Requirement requirement : decidableRequirements) {
				sb.append("<li>");
				sb.append(requirement.toHtml());
				sb.append("</li>");
			}
			sb.append("</ul>");
		}

		sb.append("</div>");
		html.setHTML(sb.toString());
	}
}
