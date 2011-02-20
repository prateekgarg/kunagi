package scrum.server.task;

import ilarkesto.base.time.Date;
import ilarkesto.fp.Predicate;

import java.util.LinkedList;
import java.util.List;

import scrum.server.sprint.Sprint;
import scrum.server.sprint.Task;

public class TaskDaySnapshotDao extends GTaskDaySnapshotDao {

	public TaskDaySnapshot getTaskDaySnapshot(final Task task, final Date date, boolean autoCreate) {
		TaskDaySnapshot snapshot = getEntity(new Predicate<TaskDaySnapshot>() {

			public boolean test(TaskDaySnapshot e) {
				return e.isTask(task) && e.isDate(date);
			}
		});

		if (autoCreate && snapshot == null) {
			snapshot = newEntityInstance();
			snapshot.setTask(task);
			snapshot.setDate(date);
			saveEntity(snapshot);
		}

		return snapshot;
	}

	public List<TaskDaySnapshot> getTaskDaySnapshots(Sprint sprint, Task task) {
		List<TaskDaySnapshot> ret = new LinkedList<TaskDaySnapshot>();
		Date date = sprint.getBegin();
		Date end = sprint.getEnd();
		TaskDaySnapshot previousSnapshot = null;
		while (date.isBeforeOrSame(end) && date.isPastOrToday()) {
			TaskDaySnapshot snapshot = getTaskDaySnapshot(task, date, false);
			if (snapshot == null) {
				snapshot = new TaskDaySnapshot();
				snapshot.setTask(task);
				snapshot.setDate(date);
				if (previousSnapshot != null) {
					snapshot.setRemainingWork(previousSnapshot.getRemainingWork());
					snapshot.setBurnedWork(previousSnapshot.getBurnedWork());
				}
			}
			ret.add(snapshot);
			previousSnapshot = snapshot;
			date = date.nextDay();
		}
		return ret;
	}

}