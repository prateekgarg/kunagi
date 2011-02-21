package scrum.client.task;

import java.util.Comparator;
import java.util.Map;

public class TaskDaySnapshot extends GTaskDaySnapshot {

	public TaskDaySnapshot(Map data) {
		super(data);
	}

	public static final Comparator<TaskDaySnapshot> DATE_COMPARATOR = new Comparator<TaskDaySnapshot>() {

		@Override
		public int compare(TaskDaySnapshot a, TaskDaySnapshot b) {
			return a.getDate().compareTo(b.getDate());
		}
	};

	public static final Comparator<TaskDaySnapshot> REVERSE_DATE_COMPARATOR = new Comparator<TaskDaySnapshot>() {

		@Override
		public int compare(TaskDaySnapshot a, TaskDaySnapshot b) {
			return DATE_COMPARATOR.compare(b, a);
		}
	};

}