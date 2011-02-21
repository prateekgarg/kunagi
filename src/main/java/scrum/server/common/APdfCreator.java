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
package scrum.server.common;

import ilarkesto.base.Str;
import ilarkesto.base.time.Date;
import ilarkesto.pdf.ACell;
import ilarkesto.pdf.APdfBuilder;
import ilarkesto.pdf.APdfContainerElement;
import ilarkesto.pdf.ARow;
import ilarkesto.pdf.ATable;
import ilarkesto.pdf.FontStyle;

import java.awt.Color;

import scrum.server.project.Quality;
import scrum.server.project.Requirement;

public abstract class APdfCreator {

	protected FontStyle defaultFont;
	protected FontStyle tableHeaderFont;
	protected FontStyle codeFont;
	protected FontStyle referenceFont;
	protected FontStyle fieldLabelFont;
	protected FontStyle miniLabelFont;
	protected FontStyle[] headerFonts = new FontStyle[4];
	protected Color tableHeaderBackground = Color.LIGHT_GRAY;

	protected abstract void build(APdfContainerElement pdf);

	protected abstract String getFilename();

	public APdfCreator() {
		defaultFont = new FontStyle().setSize(3);
		tableHeaderFont = new FontStyle(defaultFont).setBold(true);
		codeFont = new FontStyle(defaultFont).setFont(FontStyle.FONT_DEFAULT_FIXED);
		referenceFont = new FontStyle(defaultFont).setSize(defaultFont.getSize() - 0.5f)
				.setFont(FontStyle.FONT_DEFAULT_FIXED).setItalic(true);
		fieldLabelFont = new FontStyle(defaultFont).setItalic(true);
		miniLabelFont = new FontStyle(defaultFont).setSize(defaultFont.getSize() - 1f).setItalic(true);
		headerFonts[3] = new FontStyle(defaultFont).setSize(defaultFont.getSize() + 0.2f).setBold(true);
		headerFonts[2] = new FontStyle(defaultFont).setSize(headerFonts[3].getSize() + 0.7f).setBold(true);
		headerFonts[1] = new FontStyle(defaultFont).setSize(headerFonts[2].getSize() + 0.7f).setBold(true);
		headerFonts[0] = new FontStyle(defaultFont).setSize(headerFonts[1].getSize() + 1.5f).setBold(true);
	}

	public void createPdf(APdfBuilder pdf) {
		pdf.setDefaultFontStyle(defaultFont);
		build(pdf);
	}

	// --- helper ---

	protected void reportHeader(APdfContainerElement pdf, String title, String projectLabel) {
		pdf.paragraph().setDefaultFontStyle(headerFonts[0]).text(projectLabel);
		pdf.paragraph().setDefaultFontStyle(miniLabelFont).text(title + ", ")
				.text(Date.today().toString(Date.FORMAT_LONGMONTH_DAY_YEAR));
	}

	protected void wiki(APdfContainerElement parent, String wikiCode) {
		WikiToPdfConverter.buildPdf(parent, wikiCode, new ScrumPdfContext());
	}

	protected void requirement(APdfContainerElement pdf, Requirement req) {
		pdf.nl();

		ATable table = pdf.table(3, 20, 3, 3);

		ARow rowHeader = table.row().setDefaultBackgroundColor(Color.LIGHT_GRAY);
		rowHeader.cell().setFontStyle(referenceFont).text(req.getReference());
		rowHeader.cell().setColspan(2).setFontStyle(new FontStyle(defaultFont).setBold(true)).text(req.getLabel());
		rowHeader.cell().text(Str.appendIfNotBlank(req.getEstimatedWorkAsString(), " SP"));

		richtextRow(table, "Story description", req.getDescription());
		richtextRow(table, "Acceptance tests", req.getTestDescription());

		table.createCellBorders(Color.GRAY, 0.2f);
	}

	protected void quality(APdfContainerElement pdf, Quality quality) {
		pdf.nl();

		ATable table = pdf.table(3, 20, 6);

		ARow rowHeader = table.row().setDefaultBackgroundColor(Color.LIGHT_GRAY);
		rowHeader.cell().setFontStyle(referenceFont).text(quality.getReference());
		rowHeader.cell().setColspan(2).setFontStyle(new FontStyle(defaultFont).setBold(true)).text(quality.getLabel());

		richtextRow(table, "Quality description", quality.getDescription());
		richtextRow(table, "Acceptance tests", quality.getTestDescription());

		table.createCellBorders(Color.GRAY, 0.2f);
	}

	private void richtextRow(ATable table, String label, String value) {
		ARow row = table.row();

		ACell valueCell = row.cell().setColspan(2);
		valueCell.paragraph().setDefaultFontStyle(miniLabelFont).text(label);
		wiki(valueCell, value);
		valueCell.setPaddingBottom(3);

		ACell commentCell = row.cell().setColspan(2);
		commentCell.paragraph().setDefaultFontStyle(miniLabelFont).text("Comments");
	}

}
