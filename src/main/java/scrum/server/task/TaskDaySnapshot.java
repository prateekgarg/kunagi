package scrum.server.task;

import scrum.server.admin.User;
import scrum.server.common.BurndownSnapshot;

public class TaskDaySnapshot extends GTaskDaySnapshot implements BurndownSnapshot {

	public void updateWithCurrentTask() {
		setRemainingWork(getTask().getRemainingWork());
		setBurnedWork(getTask().getBurnedWork());
	}

	@Override
	public boolean isVisibleFor(User user) {
		return true;
	}

	@Override
	public String toString() {
		return getDate() + " burned: " + getBurnedWork() + ", remains: " + getRemainingWork() + ", ownerId: "
				+ getOwnerId();
	}

	@Override
	public void ensureIntegrity() {
		super.ensureIntegrity();
		if (getTask() == null) {
			getDao().deleteEntity(this);
		}
	}

}