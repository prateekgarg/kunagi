/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.sprint;

import ilarkesto.base.time.Date;
import ilarkesto.fp.Predicate;
import scrum.server.project.Project;

public class SprintDao extends GSprintDao {

	public Sprint getSprintByNumber(final int number, final Project project) {
		return getEntity(new Predicate<Sprint>() {

			@Override
			public boolean test(Sprint sprint) {
				return sprint.isNumber(number) && sprint.isProject(project);
			}
		});
	}

	@Override
	public Sprint newEntityInstance() {
		Sprint sprint = super.newEntityInstance();
		sprint.setLabel("New Sprint");
		return sprint;
	}

	// --- test data ---

	public Sprint createTestSprint(Project project) {
		Date begin = Date.beforeDays(15);
		Date end = Date.inDays(15);

		Sprint sprint = newEntityInstance();
		sprint.setProject(project);
		sprint.setLabel("Our first Sprint!");
		sprint.setBegin(begin);
		sprint.setEnd(end);
		if (end.isPast()) sprint.setVelocity(20f);
		saveEntity(sprint);

		project.setCurrentSprint(sprint);

		return sprint;
	}

}
