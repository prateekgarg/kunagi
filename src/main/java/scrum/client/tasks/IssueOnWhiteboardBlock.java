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

import ilarkesto.gwt.client.AnchorPanel;
import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;
import scrum.client.issues.Issue;
import scrum.client.issues.IssueWidget;

import com.google.gwt.user.client.ui.Widget;

public class IssueOnWhiteboardBlock extends ABlockWidget<Issue> implements TrashSupport {

	private AnchorPanel statusIcon;

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Issue issue = getObject();
		statusIcon = header.addIconWrapper();
		header.addText(issue.getLabelModel());
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		Issue issue = getObject();
		header.setDragHandle(issue.getReference());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new IssueWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		throw new IllegalStateException();
	}

	public static class IssueBlockFactory implements BlockWidgetFactory<Issue> {

		@Override
		public ABlockWidget<Issue> createBlock() {
			return new IssueOnWhiteboardBlock();
		}
	}
}
