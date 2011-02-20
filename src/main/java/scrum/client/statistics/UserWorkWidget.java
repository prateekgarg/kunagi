package scrum.client.statistics;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class UserWorkWidget extends ChartWidget {

	public static final int CHART_WIDTH = 800;
	public static final int CHART_HEIGHT = 100;

	private Image sprintChart;
	private String userName;

	public UserWorkWidget() {}

	public UserWorkWidget(String userName) {
		this.userName = userName;
	}

	@Override
	protected Widget onInitialization() {
		sprintChart = new Image(getChartUrl(200));
		return sprintChart;
	}

	@Override
	protected void onUpdate() {
		int width = getChartWidth();
		sprintChart.setWidth(width + "px");
		sprintChart.setUrl(getChartUrl(width) + "&timestamp=" + System.currentTimeMillis());
	}

	private String getChartUrl(int width) {
		return getCurrentSprint().getUserChartUrl(width, CHART_HEIGHT, userName);
	}

}
