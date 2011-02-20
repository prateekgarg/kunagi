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
package scrum.client.collaboration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scrum.client.admin.User;
import scrum.client.common.AScrumWidget;
import scrum.client.project.Project;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class UsersStatusWidget extends AScrumWidget {

	private FlowPanel containerPanel;
	private Map<User, UserStatusWidget> userWidgets = new HashMap<User, UserStatusWidget>();

	@Override
	protected Widget onInitialization() {

		containerPanel = new FlowPanel();
		containerPanel.setStyleName("UsersStatusWidget");

		return containerPanel;
	}

	@Override
	protected void onUpdate() {
		if (containerPanel.getWidgetCount() > 0) {
			super.onUpdate();
			return;
		}
		Project project = getCurrentProject();
		if (project == null) return;
		List<User> users = new ArrayList<User>(project.getParticipants());
		Collections.sort(users, User.NAME_COMPARATOR);
		containerPanel.clear();
		for (User user : users) {
			UserStatusWidget widget = userWidgets.get(user);
			if (widget == null) {
				widget = new UserStatusWidget(user);
				userWidgets.put(user, widget);
			}
			containerPanel.add(widget);
			widget.update();
		}
	}

}
