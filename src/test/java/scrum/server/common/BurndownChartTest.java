package scrum.server.common;

import ilarkesto.base.Sys;
import ilarkesto.base.time.Date;
import ilarkesto.io.IO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.DefaultXYDataset;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import scrum.client.common.WeekdaySelector;
import scrum.server.sprint.SprintDaySnapshot;

public class BurndownChartTest {

	@BeforeSuite
	public void init() {
		Sys.setHeadless(true);
	}

	@Test
	public void sprintBurndown() {
		WeekdaySelector freeDays = new WeekdaySelector(65);

		List<BurndownSnapshot> shots = new ArrayList<BurndownSnapshot>();

		// shots.add(shot(new Date(2008, 7, 1), 0, 0));
		// shots.add(shot(new Date(2008, 7, 2), 0, 0));
		// shots.add(shot(new Date(2008, 7, 3), 0, 0));
		// shots.add(shot(new Date(2008, 7, 4), 5, 45));
		// shots.add(shot(new Date(2008, 7, 5), 10, 40));
		// shots.add(shot(new Date(2008, 7, 6), 15, 35));
		// shots.add(shot(new Date(2008, 7, 7), 18, 40));
		// shots.add(shot(new Date(2008, 7, 8), 25, 33));
		// shots.add(shot(new Date(2008, 7, 9), 28, 30));
		//
		// DefaultXYDataset data = BurndownChart.createSprintBurndownChartDataset(shots, new Date(2008, 7, 1),
		// new Date(
		// 2008, 7, 31), freeDays);

		shots.add(shot(new Date(2008, 7, 1), 0, 5));
		shots.add(shot(new Date(2008, 7, 2), 1, 4));
		shots.add(shot(new Date(2008, 7, 3), 1, 4));
		shots.add(shot(new Date(2008, 7, 4), 1, 5));
		shots.add(shot(new Date(2008, 7, 5), 1, 4));
		shots.add(shot(new Date(2008, 7, 6), 1, 4));
		shots.add(shot(new Date(2008, 7, 7), 2, 3));
		shots.add(shot(new Date(2008, 7, 8), 4, 0));

		DefaultXYDataset data = BurndownChart.createSprintBurndownChartDataset(shots, shots.get(0).getDate(), shots
				.get(shots.size() - 1).getDate(), freeDays);

		double tick = 1.0;
		double max = BurndownChart.getMaximum(data);

		while (max / tick > 25) {
			tick *= 2;
			if (max / tick <= 25) break;
			tick *= 2.5;
			if (max / tick <= 25) break;
			tick *= 2;
		}
		JFreeChart chart = BurndownChart.createSprintBurndownChart(data, "Date", "Work", new Date(2008, 7, 1), shots
				.get(shots.size() - 1).getDate().nextDay(), 1, 1, max * 1.1, tick, freeDays);

		File file = new File("test-output/sprintBurndownChart.png");
		IO.createDirectory(file.getParentFile());
		try {
			ChartUtilities.saveChartAsPNG(file, chart, 500, 500);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static SprintDaySnapshot shot(Date d, int b, int r) {
		SprintDaySnapshot s = new SprintDaySnapshot();
		try {
			s.setDate(d);
		} catch (NullPointerException e) {}
		try {
			s.setBurnedWork(b);
		} catch (NullPointerException e) {}
		try {
			s.setRemainingWork(r);
		} catch (NullPointerException e) {}
		return s;
	}

}
