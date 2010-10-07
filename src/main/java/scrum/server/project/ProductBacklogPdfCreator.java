package scrum.server.project;

import ilarkesto.pdf.APdfContainerElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.server.common.APdfCreator;

public class ProductBacklogPdfCreator extends APdfCreator {

	private Project project;

	public ProductBacklogPdfCreator(Project project) {
		super();
		this.project = project;
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		reportHeader(pdf, "Product Backlog", project.getLabel());

		List<Requirement> requirements = new ArrayList<Requirement>(project.getRequirements());
		Collections.sort(requirements, project.getRequirementsOrderComparator());
		for (Requirement req : requirements) {
			if (req.isClosed()) continue;
			requirement(pdf, req);
		}
	}

	@Override
	protected String getFilename() {
		return "productbacklog";
	}

}
