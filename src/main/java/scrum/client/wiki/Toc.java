package scrum.client.wiki;

import java.util.ArrayList;
import java.util.List;

public class Toc extends AWikiElement {

	private WikiModel model;

	public Toc(WikiModel model) {
		super();
		this.model = model;
	}

	@Override
	String toHtml(HtmlContext context) {
		List<Header> headers = new ArrayList<Header>();
		for (AWikiElement element : model.getElements()) {
			appendHeaders(headers, element);
		}
		if (headers.isEmpty()) return "";

		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"toc\">");
		sb.append("<ul>");
		int currentDepth = 1;
		for (Header h : headers) {

			int depth = h.getDepth();
			int diff = depth - currentDepth;
			for (int i = 0; i < diff; i++) {
				sb.append("<ul>");
			}
			for (int i = diff; i < 0; i++) {
				sb.append("</ul>");
			}
			currentDepth = depth;

			sb.append("<li>");
			sb.append("<a ").append(context.getTocHrefOrOnclickAParameter(h)).append(">");
			sb.append(escapeHtml(h.getText()));
			sb.append("</a>");
			sb.append("</li>");
		}
		while (currentDepth > 1) {
			sb.append("</ul>");
			currentDepth--;
		}
		sb.append("</ul>");
		sb.append("</div>");
		return sb.toString();
	}

	private void appendHeaders(List<Header> headers, AWikiElement element) {
		if (element instanceof Paragraph) {
			Paragraph p = (Paragraph) element;
			for (AWikiElement e : p.getElements()) {
				appendHeaders(headers, e);
			}
			return;
		}
		if (element instanceof Header) headers.add((Header) element);
	}

	@Override
	public String toString() {
		return "Toc";
	}

}
