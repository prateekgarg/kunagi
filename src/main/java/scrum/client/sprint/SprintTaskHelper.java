/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package scrum.client.sprint;

public class SprintTaskHelper {

	public static void incrementBurnedWork(SprintTask task) {
		task.setBurnedWork(task.getBurnedWork() + 1);
	}

	public static void decrementBurnedWork(SprintTask task) {
		if (task.getBurnedWork() == 0) return;
		task.setBurnedWork(task.getBurnedWork() - 1);
	}

	public static void adjustRemainingWork(SprintTask task, int burned) {
		int remaining = task.getRemainingWork();
		if (remaining == 0) return;
		remaining -= burned;
		if (remaining < 1) remaining = 1;
		task.setRemainingWork(remaining);
	}

	public static void incrementRemainingWork(SprintTask task) {
		task.setRemainingWork(task.getRemainingWork() + 1);
	}

	public static void decrementRemainingWork(SprintTask task) {
		int work = task.getRemainingWork();
		if (work <= 1) return;
		task.setRemainingWork(work - 1);
	}

	public static <T extends SprintTask> int sumBurnedWork(Iterable<T> tasks) {
		int sum = 0;
		for (T task : tasks) {
			sum += task.getBurnedWork();
		}
		return sum;
	}

	public static <T extends SprintTask> int sumRemainingWork(Iterable<T> tasks) {
		int sum = 0;
		for (T task : tasks) {
			sum += task.getRemainingWork();
		}
		return sum;
	}

}
