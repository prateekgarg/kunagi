package scrum.server.sprint;

import ilarkesto.testng.ATest;

import org.testng.annotations.Test;

import scrum.TestUtil;
import scrum.server.project.Requirement;

public class SprintReportHelperTest extends ATest {

	@Test
	public void encodeRequirement() {
		Requirement req = TestUtil.createRequirement(TestUtil.createProject(), 1);
		req.setLabel("Story ;x");
		req.setEstimatedWork(13f);
		assertEquals(SprintReportHelper.encodeRequirement(req), "sto1;13;Story ;x");
	}

	@Test
	public void decodeRequirement() {
		String[] req = SprintReportHelper.decodeRequirement("sto1;13;Story ;x");
		assertEquals(req, new String[] { "sto1", "13", "Story ;x" });
	}

	@Test
	public void encodeTask() {
		Requirement req = TestUtil.createRequirement(TestUtil.createProject(), 2);
		Task tsk = TestUtil.createTask(req, 1, 1);
		tsk.setLabel("Task;X :-D");
		tsk.setBurnedWork(6);
		assertEquals(SprintReportHelper.encodeTask(tsk), "tsk1;6;1;Task;X :-D");
	}

	@Test
	public void decodeTask() {
		String[] req = SprintReportHelper.decodeTask("tsk1;6;1;Task;X :-D");
		assertEquals(req, new String[] { "tsk1", "6", "1", "Task;X :-D" });
	}

}
