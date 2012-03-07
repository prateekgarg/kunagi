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

import ilarkesto.gwt.client.Gwt;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.ScrumGwt;
import scrum.client.common.ABlockWidget;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockListWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.img.Img;
import scrum.client.journal.ChangeHistoryWidget;
import scrum.client.project.Requirement;
import scrum.client.project.RequirementWidget;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class RequirementInHistoryBlock extends ABlockWidget<Requirement> {

	private Sprint sprint;
	private BlockListWidget<Task> taskList;
	private RequirementWidget requirementWidget;
	private FlowPanel right;
	private FlexTable bodyWidget;
	private ChangeHistoryWidget changeHistoryWidget;

	public RequirementInHistoryBlock(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Requirement requirement = getObject();

		SprintReport report = sprint.getSprintReport();
		boolean completed = report.containsCompletedRequirement(requirement);
		Image statusImage = null;
		if (completed) {
			statusImage = Img.bundle.reqClosed().createImage();
			statusImage.setTitle("Completed.");
		} else {
			statusImage = Img.bundle.reqRejected().createImage();
			statusImage.setTitle("Rejected.");
		}
		header.addIconWrapper().setWidget(statusImage);
		header.addText(requirement.getLabelModel());
		header.addText(requirement.getThemesAsStringModel(), true, false);

		header.setDragHandle(requirement.getReference());
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {}

	@Override
	protected Widget onExtendedInitialization() {
		Requirement requirement = getObject();

		requirementWidget = new RequirementWidget(requirement, false, false, false, true, false, false, false);
		taskList = new BlockListWidget<Task>(TaskInRequirementBlock.FACTORY);
		taskList.setAutoSorter(sprint.getTasksOrderComparator());
		changeHistoryWidget = new ChangeHistoryWidget(requirement);

		FlowPanel left = new FlowPanel();
		left.add(requirementWidget);
		left.add(taskList);
		left.add(changeHistoryWidget);

		right = new FlowPanel();
		if (requirement.isDecidable() && requirement.getProject().isProductOwner(getCurrentUser())) {
			right.add(RequirementWidget.createActionsPanelForCompletedRequirement(requirement));
			right.add(Gwt.createSpacer(1, 10));
		}
		right.add(ScrumGwt.createEmoticonsAndComments(requirement));

		bodyWidget = TableBuilder.row(20, left, right);
		return bodyWidget;
	}

	@Override
	protected void onUpdateBody() {
		requirementWidget.update();
		taskList.setObjects(getObject().getTasks());
		taskList.update();
		Gwt.update(right);
		changeHistoryWidget.update();
	}

	public void selectTask(Task task) {
		taskList.showObject(task);
	}

	public static BlockWidgetFactory<Requirement> createFactory(final Sprint sprint) {
		return new BlockWidgetFactory<Requirement>() {

			@Override
			public RequirementInHistoryBlock createBlock() {
				return new RequirementInHistoryBlock(sprint);
			}
		};
	}

}
