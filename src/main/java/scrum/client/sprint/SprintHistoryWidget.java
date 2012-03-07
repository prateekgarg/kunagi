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
package scrum.client.sprint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scrum.client.common.AScrumWidget;
import scrum.client.project.Requirement;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class SprintHistoryWidget extends AScrumWidget {

	Map<Sprint, SprintHistorySprintWidget> sprintWidgets = new HashMap<Sprint, SprintHistorySprintWidget>();

	@Override
	protected Widget onInitialization() {
		PagePanel page = new PagePanel();

		List<Sprint> sprints = getCurrentProject().getCompletedSprints();
		for (Sprint sprint : sprints) {
			page.addHeader(sprint.getReferenceAndLabel());
			SprintHistorySprintWidget widget = new SprintHistorySprintWidget(sprint);
			sprintWidgets.put(sprint, widget);
			page.addSection(widget);
		}

		return page;
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
	}

	public boolean select(Requirement requirement) {
		List<Sprint> sprints = new ArrayList(getDao().getSprints());
		Collections.sort(sprints, Sprint.END_DATE_COMPARATOR);
		for (Sprint sprint : sprints) {
			SprintReport report = sprint.getSprintReport();
			if (report == null) {
				continue; // TODO legacy workaround
			}
			if (report.containsCompletedRequirement(requirement) || report.containsRejectedRequirement(requirement)) {
				SprintHistorySprintWidget sprintHistorySprintWidget = sprintWidgets.get(sprint);
				return sprintHistorySprintWidget.selectRequirement(requirement);
			}
		}
		return false;
	}

	public boolean select(Sprint sprint) {
		// FIXME
		// return sprintList.showObject(sprint);
		return true;
	}
}
