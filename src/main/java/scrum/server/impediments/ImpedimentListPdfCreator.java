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
package scrum.server.impediments;

import ilarkesto.pdf.APdfContainerElement;
import ilarkesto.pdf.FieldList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.server.common.APdfCreator;
import scrum.server.project.Project;

public class ImpedimentListPdfCreator extends APdfCreator {

	private Project project;

	public ImpedimentListPdfCreator(Project project) {
		super();
		this.project = project;
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		pdf.paragraph().text("Impediments", headerFonts[0]);

		List<Impediment> impediments = new ArrayList<Impediment>(project.getImpediments());
		Collections.sort(impediments);
		for (Impediment imp : impediments) {
			if (imp.isClosed()) continue;
			pdf.nl();
			pdf.paragraph().text(imp.getReferenceAndLabel(), headerFonts[2]);
			wiki(pdf, imp.getDescription());
			pdf.nl();
			FieldList fields = pdf.fieldList().setLabelFontStyle(fieldLabelFont);
			fields.field("Date").text(imp.getDate());
			if (imp.isSolutionSet()) wiki(fields.field("Solution"), imp.getSolution());
		}
	}

	@Override
	protected String getFilename() {
		return "impediments";
	}

}
