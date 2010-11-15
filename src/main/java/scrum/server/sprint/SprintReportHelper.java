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

	public static List<String[]> decodeRequirementsAndTasks(String s) {
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

	public boolean isDecodable(String s) {
		if (Str.isBlank(s)) return true;
		return s.startsWith(PREFIX);
	}

	public static String encodeRequirement(Requirement req) {
		StringBuilder sb = new StringBuilder();
		sb.append(req.getReference()).append(SEPARATOR);
		sb.append(req.getEstimatedWorkAsString()).append(SEPARATOR);
		sb.append(req.getLabel());
		return sb.toString();
	}

	public static String encodeTask(Task tsk) {
		StringBuilder sb = new StringBuilder();
		sb.append(tsk.getReference()).append(SEPARATOR);
		sb.append(tsk.getBurnedWork()).append(SEPARATOR);
		sb.append(tsk.getRemainingWork()).append(SEPARATOR);
		sb.append(tsk.getLabel());
		return sb.toString();
	}

	public static String[] decodeRequirement(String s) {
		String[] ret = new String[3];
		int idx = s.indexOf(SEPARATOR);
		ret[0] = s.substring(0, idx);
		s = s.substring(idx + 1);
		idx = s.indexOf(SEPARATOR);
		ret[1] = s.substring(0, idx);
		ret[2] = s.substring(idx + 1);
		return ret;
	}

	public static String[] decodeTask(String s) {
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

}
