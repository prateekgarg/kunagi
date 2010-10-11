package scrum.client.wiki;

public class Header extends AWikiElement {

	private int depth;
	private String text;
	private String anchor;

	public Header(String text, int depth) {
		super();
		this.text = text;
		this.depth = depth;
	}

	@Override
	String toHtml(HtmlContext context) {
		return "<a name=\"" + getAnchor() + "\"></a><h" + depth + ">" + escapeHtml(text) + "</h" + depth + ">";
	}

	@Override
	public String toString() {
		return "Text(\"" + text + "\")";
	}

	public int getDepth() {
		return depth;
	}

	public String getText() {
		return text;
	}

	public String getAnchor() {
		if (anchor == null) {
			StringBuilder sb = new StringBuilder();
			sb.append("wiki_h").append(depth).append("_");
			int len = text.length();
			for (int i = 0; i < len; i++) {
				char ch = text.charAt(i);
				sb.append(Character.isLetterOrDigit(ch) ? ch : "_");
			}
			anchor = sb.toString();
		}
		return anchor;
	}

}
