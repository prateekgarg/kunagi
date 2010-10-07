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
		codeFont = new FontStyle(defaultFont).setFont("Courier");
		referenceFont = new FontStyle(defaultFont).setSize(defaultFont.getSize() - 0.5f).setFont("Courier")
				.setItalic(true);
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
