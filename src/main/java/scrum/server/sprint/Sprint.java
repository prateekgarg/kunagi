package scrum.server.sprint;

import ilarkesto.base.Str;
import ilarkesto.base.Utl;
import ilarkesto.base.time.Date;
import ilarkesto.core.logging.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import scrum.server.admin.User;
import scrum.server.common.Numbered;
import scrum.server.project.Project;
import scrum.server.project.Requirement;
import scrum.server.release.Release;

public class Sprint extends GSprint implements Numbered {

	private static final Log LOG = Log.get(Sprint.class);

	// --- dependencies ---

	private static TaskDao taskDao;

	public static void setTaskDao(TaskDao taskDao) {
		Sprint.taskDao = taskDao;
	}

	// --- ---

	public Release getRelease() {
		Set<Release> releases = getReleases();
		return releases.isEmpty() ? null : Utl.getElement(releases, 0);
	}

	public void close() {
		float velocity = 0;
		Collection<Requirement> completedRequirements = new ArrayList<Requirement>();
		Collection<Requirement> incompletedRequirements = new ArrayList<Requirement>();
		List<Requirement> requirements = new ArrayList<Requirement>(getRequirements());
		Collections.sort(requirements, getProject().getRequirementsOrderComparator());
		for (Requirement requirement : requirements) {
			List<Task> tasks = new ArrayList<Task>(requirement.getTasks());
			Collections.sort(tasks, requirement.getTasksOrderComparator());
			if (requirement.isClosed()) {
				completedRequirements.add(requirement);
				Float work = requirement.getEstimatedWork();
				if (work != null) velocity += work;
				for (Task task : tasks) {
					taskDao.deleteEntity(task);
				}
			} else {
				incompletedRequirements.add(requirement);
				for (Task task : tasks) {
					if (task.isClosed()) {
						taskDao.deleteEntity(task);
					} else {
						task.reset();
					}
				}
			}
			requirement.setSprint(null);
		}
		setVelocity(velocity);
		setCompletedRequirementsData(SprintReportHelper.encodeRequirementsAndTasks(completedRequirements));
		setIncompletedRequirementsData(SprintReportHelper.encodeRequirementsAndTasks(incompletedRequirements));
		Project project = getProject();
		setProductOwners(project.getProductOwners());
		setScrumMasters(project.getScrumMasters());
		setTeamMembers(project.getTeamMembers());
		project.setVelocity(Math.round(velocity));
	}

	public String getProductOwnersAsString() {
		return Str.concat(User.getNames(getProductOwners()), ", ");
	}

	public String getScrumMastersAsString() {
		return Str.concat(User.getNames(getScrumMasters()), ", ");
	}

	public String getTeamMembersAsString() {
		return Str.concat(User.getNames(getTeamMembers()), ", ");
	}

	public List<SprintDaySnapshot> getDaySnapshots() {
		return sprintDaySnapshotDao.getSprintDaySnapshots(this);
	}

	public Set<SprintDaySnapshot> getExistingDaySnapshots() {
		return sprintDaySnapshotDao.getSprintDaySnapshotsBySprint(this);
	}

	public Integer getLengthInDays() {
		if (!isBeginSet() || !isEndSet()) return null;
		return getBegin().getPeriodTo(getEnd()).toDays();
	}

	public SprintDaySnapshot getDaySnapshot(Date date) {
		return sprintDaySnapshotDao.getSprintDaySnapshot(this, date, true);
	}

	public int getRemainingWork() {
		int sum = 0;
		for (Task task : getTasks()) {
			Integer effort = task.getRemainingWork();
			if (effort != null) sum += effort;
		}
		return sum;
	}

	public int getBurnedWork() {
		int sum = 0;
		for (Task task : getTasks()) {
			sum += task.getBurnedWork();
		}
		return sum;
	}

	public Set<Task> getTasks() {
		return taskDao.getTasksBySprint(this);
	}

	public String getReference() {
		return scrum.client.sprint.Sprint.REFERENCE_PREFIX + getNumber();
	}

	@Override
	public void updateNumber() {
		if (getNumber() == 0) setNumber(getProject().generateSprintNumber());
	}

	@Override
	public void ensureIntegrity() {
		super.ensureIntegrity();
		updateNumber();

		if (getProject().isCurrentSprint(this)) {
			if (!isBeginSet()) setBegin(Date.today());
			if (!isEndSet()) setEnd(getBegin().addDays(14));
		}

		// delete when not current and end date older than 4 weeks
		// if (isEndSet() && !getProject().isCurrentSprint(this) && getEnd().isPast()
		// && getEnd().getPeriodToNow().toWeeks() > 4) {
		// LOG.info("Deleting sprint, which ended on", getEnd(), "->", toString());
		// getDao().deleteEntity(this);
		// }

	}

	@Override
	public boolean isVisibleFor(User user) {
		return getProject().isVisibleFor(user);
	}

	public String getReferenceAndLabel() {
		return getReference() + " " + getLabel();
	}

	@Override
	public String toString() {
		return getReferenceAndLabel();
	}

	public void burndownTasksRandomly(Date begin, Date end) {
		int days = getBegin().getPeriodTo(getEnd()).toDays();
		days -= (days / 7) * 2;
		int defaultWorkPerDay = getRemainingWork() / days;

		getDaySnapshot(begin).updateWithCurrentSprint();
		begin = begin.nextDay();
		while (begin.isBefore(end)) {
			if (!begin.isWeekend()) {
				int toBurn = Utl.randomInt(0, defaultWorkPerDay + (defaultWorkPerDay * 2));
				int totalRemaining = getRemainingWork();
				for (Task task : getTasks()) {
					if (toBurn == 0) break;
					int remaining = task.getRemainingWork();
					int burn = Math.min(toBurn, remaining);
					remaining -= burn;
					toBurn -= burn;
					task.setBurnedWork(task.getBurnedWork() + burn);
					if (Utl.randomInt(1, 10) == 1) {
						remaining += Utl.randomInt(-defaultWorkPerDay * 2, defaultWorkPerDay * 3);
					}
					if (totalRemaining == 0) {
						remaining += Utl.randomInt(defaultWorkPerDay * 3, defaultWorkPerDay * 5);
						totalRemaining = remaining;
					}
					task.setRemainingWork(remaining);
				}
			}
			getDaySnapshot(begin).updateWithCurrentSprint();
			begin = begin.nextDay();
		}
	}

}
