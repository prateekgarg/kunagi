package scrum.client.task;

import ilarkesto.gwt.client.Date;

import java.util.Comparator;

import scrum.client.sprint.Task;

public class BurnHours {

	private Task task;
	private Date date;
	private int remainingWork;
	private int burnedWork;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRemainingWork() {
		return remainingWork;
	}

	public void setRemainingWork(int remainingWork) {
		this.remainingWork = remainingWork;
	}

	public int getBurnedWork() {
		return burnedWork;
	}

	public void setBurnedWork(int burnedWork) {
		this.burnedWork = burnedWork;
	}

	public static final Comparator<BurnHours> DATE_COMPARATOR = new Comparator<BurnHours>() {

		@Override
		public int compare(BurnHours a, BurnHours b) {
			return a.getDate().compareTo(b.getDate());
		}
	};

	public static final Comparator<BurnHours> REVERSE_DATE_COMPARATOR = new Comparator<BurnHours>() {

		@Override
		public int compare(BurnHours a, BurnHours b) {
			return DATE_COMPARATOR.compare(b, a);
		}
	};
}
