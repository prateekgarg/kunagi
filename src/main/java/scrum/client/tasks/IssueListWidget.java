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
package scrum.client.tasks;

import ilarkesto.gwt.client.animation.AnimatingFlowPanel.InsertCallback;

import java.util.List;

import scrum.client.common.AScrumWidget;
import scrum.client.common.BlockListSelectionManager;
import scrum.client.common.BlockListWidget;
import scrum.client.dnd.BlockListDropAction;
import scrum.client.issues.Issue;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class IssueListWidget extends AScrumWidget {

	private BlockListWidget<Issue> list;
	private BlockListDropAction<Issue> dropAction;

	public IssueListWidget(BlockListDropAction<Issue> dropAction) {
		this.dropAction = dropAction;
	}

	public Issue getSelectedIssue() {
		return list == null ? null : list.getExtendedObject();
	}

	public void setSelectionManager(BlockListSelectionManager sm) {
		list.setSelectionManager(sm);
	}

	@Override
	protected Widget onInitialization() {
		list = new BlockListWidget<Issue>(new IssueOnWhiteboardBlock.IssueBlockFactory(), this.dropAction);
		list.setMinHeight(100);
		// list.setAutoSorter(requirement.getTasksOrderComparator());
		if (getCurrentProject().isTeamMember(getCurrentUser())) {
			// list.setDndSorting(createTaskButton);
			list.setMoveObserver(new MoveObserver());
		}

		FlowPanel panel = new FlowPanel();
		panel.add(list);

		return panel;
	}

	public boolean selectIssue(Issue issue) {
		if (!list.contains(issue)) update();
		return list.showObject(issue);
	}

	public void setIssues(List<Issue> issues) {
		initialize();
		list.setObjects(issues);
	}

	class MoveObserver implements InsertCallback {

		@Override
		public void onInserted(int index) {
			List<Issue> issues = list.getObjects();
			// requirement.updateTasksOrder(issues);
			update();
		}

	}
}
