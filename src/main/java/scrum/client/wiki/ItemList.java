package scrum.client.wiki;

import ilarkesto.gwt.client.Gwt;

import java.util.ArrayList;
import java.util.List;

public class ItemList extends AWikiElement {

	private List<Item> items = new ArrayList<Item>();
	boolean ordered;
	private int leadingSpacesLength;

	public ItemList(boolean ordered, int leadingSpacesLenght) {
		super();
		this.ordered = ordered;
		this.leadingSpacesLength = leadingSpacesLenght;
	}

	public void add(Paragraph item) {
		items.add(new Item(item, -1));
	}

	public void add(Paragraph item, String leadingSpaces, boolean ordered, int numberValue) {
		if (leadingSpaces.length() > 0 && leadingSpaces.length() > leadingSpacesLength) {
			Item lastItem = items.get(items.size() - 1);
			if (lastItem.list == null) {
				lastItem.list = new ItemList(ordered, leadingSpaces.length());
				lastItem.list.add(item);
			} else {
				lastItem.list.add(item, leadingSpaces.substring(leadingSpacesLength), ordered);
			}
			return;
		}
		items.add(new Item(item, numberValue));
	}

	public void add(Paragraph item, String leadingSpaces, boolean ordered) {
		add(item, leadingSpaces, ordered, -1);
	}

	public void setLeadingSpacesLength(int leadingSpacesLength) {
		this.leadingSpacesLength = leadingSpacesLength;
	}

	@Override
	String toHtml(HtmlContext context) {
		StringBuilder sb = new StringBuilder();
		sb.append(ordered ? "<ol>" : "<ul>");
		for (Item item : items) {
			sb.append((item.getNumberValue() > -1) ? "<li value=\"" + item.getNumberValue() + "\">" : "<li>");
			sb.append(item.p.toHtml(context));
			if (item.containsList()) {
				sb.append(item.list.toHtml(context));
			}
			sb.append("</li>");
		}
		sb.append(ordered ? "</ol>" : "</ul>");
		return sb.toString();
	}

	public List<Item> getItems() {
		return items;
	}

	public boolean isOrdered() {
		return ordered;
	}

	@Override
	public String toString() {
		return "ItemList(" + Gwt.toString(items) + ")";
	}

	public class Item {

		Paragraph p;
		ItemList list;
		int numberValue = -1;

		public Item(Paragraph p, int numberValue) {
			super();
			this.p = p;
			this.numberValue = numberValue;
		}

		public int getNumberValue() {
			return numberValue;
		}

		public Paragraph getParagraph() {
			return p;
		}

		public ItemList getList() {
			return list;
		}

		public boolean containsList() {
			return list != null;
		}

		@Override
		public String toString() {
			return containsList() ? "Item(" + p + "," + list + ")" : p.toString();
		}
	}

}
