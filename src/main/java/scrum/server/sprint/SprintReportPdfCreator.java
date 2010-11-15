package scrum.server.sprint;

import ilarkesto.pdf.APdfContainerElement;
import ilarkesto.pdf.FieldList;
import scrum.server.common.APdfCreator;
import scrum.server.common.BurndownChart;
import scrum.server.common.ScrumPdfContext;
import scrum.server.common.WikiToPdfConverter;

public class SprintReportPdfCreator extends APdfCreator {

	private Sprint sprint;

	public SprintReportPdfCreator(Sprint sprint) {
		super();
		this.sprint = sprint;
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		reportHeader(pdf, "Sprint Report", sprint.getProject().getLabel());

		FieldList fields = pdf.fieldList().setLabelFontStyle(fieldLabelFont);
		fields.field("Sprint").text(sprint.getLabel());
		fields.field("Period").text(
			sprint.getBegin() + " - " + sprint.getEnd() + " / " + sprint.getLengthInDays() + " days");
		fields.field("Velocity").text(sprint.getVelocity() + " StoryPoints");
		fields.field("Product Owner").text(sprint.getProductOwnersAsString());
		fields.field("Scrum Master").text(sprint.getScrumMastersAsString());
		fields.field("Team").text(sprint.getTeamMembersAsString());

		pdf.nl();
		pdf.image(BurndownChart.createBurndownChartAsByteArray(sprint, 1000, 500)).setScaleByWidth(150f);

		if (sprint.isGoalSet()) {
			sectionHeader(pdf, "Goal");
			WikiToPdfConverter.buildPdf(pdf, sprint.getGoal(), new ScrumPdfContext());
		}

		if (sprint.isCompletedRequirementLabelsSet()) {
			sectionHeader(pdf, "Completed Stories");
			WikiToPdfConverter.buildPdf(pdf, sprint.getCompletedRequirementLabels(), new ScrumPdfContext());
		}

		if (sprint.isReviewNoteSet()) {
			sectionHeader(pdf, "Review notes");
			WikiToPdfConverter.buildPdf(pdf, sprint.getReviewNote(), new ScrumPdfContext());
		}

		if (sprint.isRetrospectiveNoteSet()) {
			sectionHeader(pdf, "Retrospecitve notes");
			WikiToPdfConverter.buildPdf(pdf, sprint.getRetrospectiveNote(), new ScrumPdfContext());
		}

	}

	private void sectionHeader(APdfContainerElement pdf, String label) {
		pdf.paragraph().nl().text(label, headerFonts[1]).nl();
	}

	@Override
	protected String getFilename() {
		return "sprint";
	}

}
