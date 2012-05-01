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
package scrum.client.common;

import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.Gwt;

import java.util.List;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class SparklineChartWidget extends AWidget {

	private int height;
	private int barWidth;
	private List<Float> values;
	private String barColor = "darkgray";
	private float heightFactor;

	public SparklineChartWidget(int height, int barWidth, List<Float> values) {
		super();
		this.height = height;
		this.barWidth = barWidth;
		this.values = values;
	}

	@Override
	protected Widget onInitialization() {
		FlowPanel container = new FlowPanel();

		heightFactor = computeFactor();

		boolean first = true;
		for (Float value : values) {
			if (first) {
				first = false;
			} else {
				container.add(Gwt.createSpacer(1, 1));
			}
			container.add(createBar(value));
		}

		return container;
	}

	private Widget createBar(Float value) {
		FlowPanel bar = new FlowPanel();
		int barheight = (int) (value * heightFactor);
		bar.setHeight(barheight + "px");
		bar.setWidth(barWidth + "px");
		bar.getElement().getStyle().setBackgroundColor(barColor);
		return bar;
	}

	private float computeFactor() {
		float max = 0;
		for (Float value : values) {
			if (value > max) max = value;
		}
		return height / max;
	}

}
