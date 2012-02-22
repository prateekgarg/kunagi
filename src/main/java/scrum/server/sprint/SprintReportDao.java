package scrum.server.sprint;

public class SprintReportDao extends GSprintReportDao {

	public SprintReport postSprintReport(Sprint sprint) {
		SprintReport report = newEntityInstance();
		report.setSprint(sprint);

		saveEntity(report);
		return report;
	}

}