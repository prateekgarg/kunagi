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
package scrum.client.sprint;

import ilarkesto.gwt.client.Gwt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.client.common.AScrumWidget;
import scrum.client.common.BlockListWidget;
import scrum.client.project.Requirement;

import com.google.gwt.user.client.ui.Widget;

public class SprintHistorySprintWidget extends AScrumWidget {

	private Sprint sprint;
	private BlockListWidget<Requirement> requirementList;

	public SprintHistorySprintWidget(Sprint sprint) {
		super();
		this.sprint = sprint;
	}

	@Override
	protected Widget onInitialization() {
		SprintReport report = sprint.getSprintReport();

		List<Requirement> requirements = new ArrayList<Requirement>();

		if (report != null) {
			requirements.addAll(report.getCompletedRequirements());
			requirements.addAll(report.getRejectedRequirements());
			Collections.sort(requirements, sprint.getRequirementsOrderComparator());
		}

		requirementList = new BlockListWidget<Requirement>(RequirementInHistoryBlock.createFactory(sprint));
		requirementList.setAutoSorter(sprint.getRequirementsOrderComparator());
		requirementList.setObjects(requirements);

		return Gwt.createFlowPanel(requirementList, new SprintWidget(sprint));
	}

	public boolean selectRequirement(Requirement r) {
		return requirementList.showObject(r);
	}

	public void selectTask(Task task) {
		update();
		RequirementInSprintBlock rBlock = (RequirementInSprintBlock) requirementList.getBlock(task.getRequirement());
		requirementList.extendBlock(rBlock, true);
		rBlock.selectTask(task);
	}

}
