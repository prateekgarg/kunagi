/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.project;

import ilarkesto.core.base.Str;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import scrum.client.common.LabelSupport;
import scrum.client.common.ReferenceSupport;
import scrum.server.admin.User;
import scrum.server.common.Numbered;
import scrum.server.estimation.RequirementEstimationVote;
import scrum.server.sprint.Task;

public class Requirement extends GRequirement implements Numbered, ReferenceSupport, LabelSupport {

	private transient Comparator<Task> tasksOrderComparator;

	public String getEstimatedWorkAsString() {
		Float work = getEstimatedWork();
		if (work == null) return null;
		if (work <= 0.5f) return work.toString();
		return String.valueOf(work.intValue());
	}

	public void setEstimatedWorkAsString(String value) {
		if (Str.isBlank(value)) {
			setEstimatedWork(null);
			return;
		}
		setEstimatedWork(Float.parseFloat(value));
	}

	public boolean isInCurrentSprint() {
		if (!isSprintSet()) return false;
		return isSprint(getProject().getCurrentSprint());
	}

	public void initializeEstimationVotes() {
		for (User user : getProject().getTeamMembers()) {
			RequirementEstimationVote vote = getEstimationVote(user);
			if (vote == null) vote = requirementEstimationVoteDao.postVote(this, user);
			vote.setEstimatedWork(null);
		}
	}

	private RequirementEstimationVote getEstimationVote(User user) {
		return requirementEstimationVoteDao.getRequirementEstimationVoteByUser(this, user);
	}

	public Set<RequirementEstimationVote> getEstimationVotes() {
		return requirementEstimationVoteDao.getRequirementEstimationVotesByRequirement(this);
	}

	public void clearEstimationVotes() {
		for (RequirementEstimationVote vote : getEstimationVotes()) {
			requirementEstimationVoteDao.deleteEntity(vote);
		}
	}

	public boolean isTasksClosed() {
		for (Task task : getTasks()) {
			if (!task.isClosed()) return false;
		}
		return true;
	}

	public String getReferenceAndLabel() {
		StringBuilder sb = new StringBuilder();
		sb.append(getReference());
		sb.append(" ");
		sb.append(getLabel());
		if (!isThemesEmpty()) {
			sb.append(" (").append(getThemesAsCommaSeparatedString()).append(")");
		}
		return sb.toString();
	}

	@Override
	public String getReference() {
		return scrum.client.project.Requirement.REFERENCE_PREFIX + getNumber();
	}

	@Override
	public void updateNumber() {
		if (getNumber() == 0) setNumber(getProject().generateRequirementNumber());
	}

	public Comparator<Task> getTasksOrderComparator() {
		if (tasksOrderComparator == null) tasksOrderComparator = new Comparator<Task>() {

			@Override
			public int compare(Task a, Task b) {
				List<String> order = getTasksOrderIds();
				int additional = order.size();
				int ia = order.indexOf(a.getId());
				if (ia < 0) {
					ia = additional;
					additional++;
				}
				int ib = order.indexOf(b.getId());
				if (ib < 0) {
					ib = additional;
					additional++;
				}
				return ia - ib;
			}
		};
		return tasksOrderComparator;
	}

	@Override
	public void ensureIntegrity() {
		super.ensureIntegrity();
		updateNumber();

		// delete estimation votes when closed or in sprint
		if (isClosed() || isSprintSet()) clearEstimationVotes();

		// delete when closed and older than 4 weeks
		if (isClosed() && getLastModified().getPeriodToNow().toWeeks() > 4) getDao().deleteEntity(this);

	}

	@Override
	public boolean isVisibleFor(User user) {
		return getProject().isVisibleFor(user);
	}

	@Override
	public String toString() {
		return getReferenceAndLabel();
	}

}
