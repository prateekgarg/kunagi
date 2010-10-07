package scrum.server.sprint;

import ilarkesto.pdf.APdfContainerElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.server.common.APdfCreator;
import scrum.server.common.BurndownChart;
import scrum.server.project.Project;
import scrum.server.project.Requirement;

public class SprintBacklogPdfCreator extends APdfCreator {

	private Project project;

	public SprintBacklogPdfCreator(Project project) {
		super();
		this.project = project;
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		Sprint sprint = project.getCurrentSprint();

		reportHeader(pdf, "Sprint Backlog", project.getLabel());

		pdf.nl();
		pdf.image(BurndownChart.createBurndownChartAsByteArray(sprint, 1000, 500)).setScaleByWidth(150f);

		pdf.nl();
		List<Requirement> requirements = new ArrayList<Requirement>(sprint.getRequirements());
		Collections.sort(requirements, project.getRequirementsOrderComparator());
		for (Requirement req : requirements) {
			requirement(pdf, req);
			// TODO burned work, estimated work
		}

	}

	@Override
	protected String getFilename() {
		return "sprintbacklog";
	}

}
