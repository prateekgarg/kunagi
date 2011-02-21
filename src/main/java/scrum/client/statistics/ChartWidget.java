package scrum.client.statistics;

import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.Window;

public abstract class ChartWidget extends AScrumWidget {

	public int getChartWidth() {
		int width = Window.getClientWidth() - 280;
		width = width / 2;
		if (width < 100) width = 100;
		return width;
	}
}
