package scrum.client;

import ilarkesto.core.base.Str;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.DateAndTime;
import ilarkesto.gwt.client.Gwt;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.collaboration.CommentsWidget;
import scrum.client.collaboration.EmoticonSelectorWidget;
import scrum.client.common.AScrumGwtEntity;
import scrum.client.common.LabelSupport;
import scrum.client.common.ReferenceSupport;
import scrum.client.project.Project;
import scrum.client.workspace.Navigator;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ScrumGwt extends Gwt {

	public static boolean isEntityReferenceOrWikiPage(String s) {
		if (s == null) return false;
		if (s.startsWith("[") && s.endsWith("]")) return true;
		return isEntityReference(s);
	}

	public static boolean isEntityReference(String s) {
		if (s.length() < 4) return false;
		if (!Character.isDigit(s.charAt(3))) return false;

		boolean prefixOk = false;
		for (String prefix : ScrumGwtApplication.REFERENCE_PREFIXES) {
			if (s.startsWith(prefix)) {
				prefixOk = true;
				break;
			}
		}
		if (!prefixOk) return false;

		int len = s.length();
		for (int i = 3; i < len; i++) {
			if (!Character.isDigit(s.charAt(i))) return false;
		}
		try {
			String number = s.substring(3);
			Integer.parseInt(number);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}

	public static String getPeriodToAsShortestString(String prefix, DateAndTime dateAndTime, String suffix) {
		if (dateAndTime == null) return null;
		return prefix + getPeriodToAsShortestString(dateAndTime) + suffix;
	}

	public static String getPeriodToAsShortestString(DateAndTime dateAndTime) {
		if (dateAndTime == null) return null;
		return dateAndTime.getPeriodToNow().toShortestString();
	}

	public static Widget createEmoticonsAndComments(AScrumGwtEntity entity) {
		TableBuilder tb = ScrumGwt.createFieldTable();
		tb.addFieldRow("My emoticon", new EmoticonSelectorWidget(entity));
		tb.addRow(Gwt.createSpacer(1, 5));
		tb.addRow(new CommentsWidget(entity), 2);
		return tb.createTable();
	}

	public static Widget createActionsPanel(Widget... widgets) {
		FlowPanel panel = new FlowPanel();
		panel.setStyleName("ActionsPanel");
		for (Widget widget : widgets) {
			panel.add(widget);
		}
		return panel;
	}

	public static TableBuilder createFieldTable() {
		TableBuilder tb = new TableBuilder();
		tb.setCellPadding(2);
		tb.setColumnWidths("100px");
		return tb;
	}

	public static HTML createPdfLink(String text, String pdfId, AScrumGwtEntity entity) {
		return createPdfLink(text, pdfId, "entityId", entity.getId());
	}

	public static HTML createPdfLink(String text, String pdfId, String parameterKey, String parameterValue,
			String parameter2Key, String parameter2Value) {
		return createPdfLink(text, pdfId, parameterKey + "=" + parameterValue + "&" + parameter2Key + "="
				+ parameter2Value);
	}

	public static HTML createPdfLink(String text, String pdfId, String parameterKey, String parameterValue) {
		return createPdfLink(text, pdfId, parameterKey + "=" + parameterValue);
	}

	public static HTML createPdfLink(String text, String pdfId, String parameters) {
		Project project = Scope.get().getComponent(Project.class);
		assert project != null;
		return createServletDownloadLink("pdf.pdf?projectId=" + project.getId() + "&pdfId=" + pdfId + "&" + parameters,
			text);
	}

	public static String toHtml(AScrumGwtEntity entity, String label) {
		return getReferenceAsHtmlLink(entity) + " " + escapeHtml(label);
	}

	public static String getReferenceAsHtmlLink(AScrumGwtEntity entity) {
		String reference = entity.getId();
		if (entity instanceof ReferenceSupport) {
			reference = ((ReferenceSupport) entity).getReference();
		}
		String label = entity.toString();
		if (entity instanceof LabelSupport) {
			label = ((LabelSupport) entity).getLabel();
		}
		label = Str.toHtml(label);
		return "<a href='" + Navigator.getEntityHref(entity) + "' title='" + label + "'>" + reference + "</a>";
	}

}
