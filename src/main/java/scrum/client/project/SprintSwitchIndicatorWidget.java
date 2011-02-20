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
package scrum.client.project;

import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.TimePeriod;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class SprintSwitchIndicatorWidget extends AWidget {

	private Label label;

	protected Widget onInitialization() {
		label = new Label("Estimated Sprint Switch");
		label.setStyleName("SprintBorderIndicatorWidget");
		return label;
	}

	public void updateLabel(int sprints, TimePeriod period) {
		initialize();
		String s = String.valueOf(sprints);
		if (sprints == 1) {
			s = "current";
		} else if (sprints == 2) {
			s = "next";
		}
		label.setText("After " + s + " sprint" + (sprints <= 2 ? "" : "s")
				+ (period.toMillis() <= 0 ? "" : ", in " + period.toShortestString()));
	}

}
