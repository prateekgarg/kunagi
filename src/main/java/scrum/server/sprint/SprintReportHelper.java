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

import ilarkesto.core.base.Str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import scrum.server.project.Requirement;

public class SprintReportHelper {

	private static final char SEPARATOR = ';';
	private static final String PREFIX = "#encoded-requirements ";
	private static final int VERSION = 1; // reference;work;label

	public static String encodeRequirementsAndTasks(Collection<Requirement> requirements) {
		StringBuilder sb = new StringBuilder();
		sb.append(PREFIX).append(VERSION).append("\n");
		for (Requirement req : requirements) {
			sb.append(encodeRequirement(req)).append("\n");
			for (Task task : req.getTasks()) {
				sb.append(encodeTask(task)).append("\n");
			}
		}
		return sb.toString();
	}

	public static List<StoryInfo> parseRequirementsAndTasks(String s) {
		List<StoryInfo> ret = new ArrayList<SprintReportHelper.StoryInfo>();
		List<String[]> records = decodeRequirementsAndTasks(s);
		StoryInfo story = null;
		for (String[] record : records) {
			if (record[0].startsWith(scrum.client.project.Requirement.REFERENCE_PREFIX)) {
				if (story != null) ret.add(story);
				story = new StoryInfo(record);
			} else if (record[0].startsWith(scrum.client.sprint.Task.REFERENCE_PREFIX)) {
				story.addTask(record);
			}
		}
		if (story != null) ret.add(story);
		return ret;
	}

	static List<String[]> decodeRequirementsAndTasks(String s) {
		if (Str.isBlank(s)) return Collections.emptyList();
		BufferedReader in = new BufferedReader(new StringReader(s));
		List<String[]> records = new ArrayList<String[]>();
		String line;
		try {
			line = in.readLine();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		if (line == null) return Collections.emptyList();
		if (!line.startsWith(PREFIX + VERSION)) throw new RuntimeException("Illegal format: " + s);
		try {
			line = in.readLine();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		while (line != null) {
			if (line.startsWith(scrum.client.project.Requirement.REFERENCE_PREFIX)) {
				records.add(decodeRequirement(line));
			} else if (line.startsWith(scrum.client.sprint.Task.REFERENCE_PREFIX)) {
				records.add(decodeTask(line));
			}
			try {
				line = in.readLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}
		return records;
	}

	boolean isDecodable(String s) {
		if (Str.isBlank(s)) return true;
		return s.startsWith(PREFIX);
	}

	static String encodeRequirement(Requirement req) {
		StringBuilder sb = new StringBuilder();
		sb.append(req.getReference()).append(SEPARATOR);
		sb.append(req.getEstimatedWorkAsString()).append(SEPARATOR);
		sb.append(req.getLabel());
		return sb.toString();
	}

	static String encodeTask(Task tsk) {
		StringBuilder sb = new StringBuilder();
		sb.append(tsk.getReference()).append(SEPARATOR);
		sb.append(tsk.getBurnedWork()).append(SEPARATOR);
		sb.append(tsk.getRemainingWork()).append(SEPARATOR);
		sb.append(tsk.getLabel());
		return sb.toString();
	}

	static String[] decodeRequirement(String s) {
		String[] ret = new String[3];
		int idx = s.indexOf(SEPARATOR);
		ret[0] = s.substring(0, idx);
		s = s.substring(idx + 1);
		idx = s.indexOf(SEPARATOR);
		ret[1] = s.substring(0, idx);
		ret[2] = s.substring(idx + 1);
		return ret;
	}

	static String[] decodeTask(String s) {
		String[] ret = new String[4];
		int idx = s.indexOf(SEPARATOR);
		ret[0] = s.substring(0, idx);
		s = s.substring(idx + 1);
		idx = s.indexOf(SEPARATOR);
		ret[1] = s.substring(0, idx);
		s = s.substring(idx + 1);
		idx = s.indexOf(SEPARATOR);
		ret[2] = s.substring(0, idx);
		ret[3] = s.substring(idx + 1);
		return ret;
	}

	public static class StoryInfo {

		private String reference;
		private float estimatedWork;
		private String label;
		private List<TaskInfo> tasks = new ArrayList<TaskInfo>();

		public StoryInfo(String[] record) {
			reference = record[0];
			estimatedWork = Float.parseFloat(record[1].replace(',', '.'));
			label = record[2];
		}

		public void addTask(String[] record) {
			tasks.add(new TaskInfo(record));
		}

		public String getReference() {
			return reference;
		}

		public float getEstimatedWork() {
			return estimatedWork;
		}

		public String getEstimatedWorkAsString() {
			if (estimatedWork <= 0.5f) return String.valueOf(estimatedWork) + " SP";
			return String.valueOf((int) estimatedWork) + " SP";
		}

		public String getLabel() {
			return label;
		}

		public List<TaskInfo> getTasks() {
			return tasks;
		}

		public int getBurnedWork() {
			int ret = 0;
			for (TaskInfo tsk : tasks) {
				ret += tsk.getBurnedWork();
			}
			return ret;
		}

		public String getBurnedWorkAsString() {
			int work = getBurnedWork();
			String suffix = work == 1 ? " hr." : " hrs.";
			return String.valueOf(work) + suffix;
		}
	}

	public static class TaskInfo {

		private String reference;
		private int burnedWork;
		private int remainingWork;
		private String label;

		public TaskInfo(String[] record) {
			reference = record[0];
			burnedWork = Integer.parseInt(record[1]);
			remainingWork = Integer.parseInt(record[2]);
			label = record[3];
		}

		public String getReference() {
			return reference;
		}

		public int getBurnedWork() {
			return burnedWork;
		}

		public int getRemainingWork() {
			return remainingWork;
		}

		public String getLabel() {
			return label;
		}

	}

}
