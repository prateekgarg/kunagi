package scrum.client.common;

import ilarkesto.core.base.Str;
import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.ButtonWidget;
import ilarkesto.gwt.client.DropdownMenuButtonWidget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class BlockHeaderWidget extends AWidget {

	private HorizontalPanel table;
	private FocusPanel dragHandleWrapper;
	private FlowPanel centerWrapper;
	private Anchor centerText;
	private List<Anchor> anchors;

	private DropdownMenuButtonWidget menu;
	private int prefixCellCount = 0;
	private int suffixCellCount = 0;
	private Label dragHandle;

	@Override
	protected Widget onInitialization() {
		dragHandleWrapper = new FocusPanel();
		dragHandleWrapper.setStyleName("BlockHeaderWidget-dragHandle");
		// dragHandleWrapper.setHeight("100%");

		centerText = new Anchor();
		centerText.setStyleName("BlockHeaderWidget-center-text");

		centerWrapper = new FlowPanel();
		centerWrapper.setStyleName("BlockHeaderWidget-center");
		centerWrapper.setWidth("100%");
		centerWrapper.add(centerText);

		table = new HorizontalPanel();
		table.setStyleName("BlockHeaderWidget");
		table.setWidth("100%");
		table.add(dragHandleWrapper);
		table.setCellWidth(dragHandleWrapper, "50px");
		table.add(centerWrapper);

		return table;
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
		centerText.setFocus(false);
	}

	public Anchor appendCenterSuffix(String text) {
		Anchor a = new Anchor(text);
		a.setStyleName("BlockHeaderWidget-centerSuffix");
		centerWrapper.add(a);
		if (anchors == null) anchors = new ArrayList<Anchor>(2);
		anchors.add(a);
		return a;
	}

	public Anchor insertPrefixLabel(String width, boolean secondary) {
		Anchor a = new Anchor();
		insertPrefixCell(a, width, true, "BlockHeaderWidget-prefixLabel", secondary);
		if (anchors == null) anchors = new ArrayList<Anchor>(2);
		anchors.add(a);
		return a;
	}

	public SimplePanel insertPrefixIcon() {
		SimplePanel cell = insertPrefixCell(null, "16px", false, "BlockHeaderWidget-prefixIcon", false);
		cell.setHeight("16px");
		cell.getElement().getStyle().setMarginTop(2, Unit.PX);
		return cell;
	}

	public SimplePanel insertSuffixCell(Widget widget, String width, boolean nowrap, String additionalStyleName,
			boolean secondary) {
		SimplePanel cell = createCell(widget, nowrap, additionalStyleName);
		if (secondary) cell.addStyleName("BlockHeaderWidget-cell-secondary");
		suffixCellCount++;

		table.insert(cell, prefixCellCount + 1 + suffixCellCount);
		if (width != null) table.setCellWidth(cell, width);

		return cell;
	}

	public SimplePanel insertPrefixCell(Widget widget, String width, boolean nowrap, String additionalStyleName,
			boolean secondary) {
		SimplePanel cell = createCell(widget, nowrap, additionalStyleName);
		if (secondary) cell.addStyleName("BlockHeaderWidget-cell-secondary");
		prefixCellCount++;
		table.insert(cell, prefixCellCount);
		if (width != null) {
			table.setCellWidth(cell, width);
			cell.setWidth(width);
		}
		return cell;
	}

	public void appendCell(Widget widget, String width, boolean nowrap, boolean alignRight, String additionalStyleName) {
		SimplePanel cell = createCell(widget, nowrap, additionalStyleName);
		table.add(cell);
		if (alignRight) table.setCellHorizontalAlignment(cell, HorizontalPanel.ALIGN_RIGHT);
		if (width != null) table.setCellWidth(cell, width);
	}

	private SimplePanel createCell(Widget widget, boolean nowrap, String additionalStyleName) {
		SimplePanel wrapper = new SimplePanel();
		wrapper.setStyleName("BlockHeaderWidget-cell");
		wrapper.setHeight("100%");
		if (nowrap) wrapper.getElement().getStyle().setProperty("whiteSpace", "nowrap");
		if (additionalStyleName != null) wrapper.addStyleName(additionalStyleName);
		wrapper.setWidget(widget);
		return wrapper;
	}

	public void addMenuAction(AScrumAction action) {
		if (menu == null) {
			menu = new DropdownMenuButtonWidget();
			appendCell(menu, "30px", true, false, null);
		}
		menu.addAction(action);
	}

	public void addToolbarAction(AAction action) {
		appendCell(new ButtonWidget(action), "5px", true, false, null);
	}

	public void setDragHandle(String text) {
		if (dragHandle == null) {
			dragHandle = new Label();
			setDragHandle(dragHandle);
		}
		dragHandle.setText(text);
	}

	public void setDragHandle(Widget widget) {
		dragHandleWrapper.setWidget(widget);
	}

	public void setCenter(String text) {
		if (Str.isBlank(text)) text = "<new>";
		centerText.setText(text);
	}

	public void addClickHandler(ClickHandler handler) {
		centerText.addClickHandler(handler);
		if (anchors != null) {
			for (Anchor a : anchors) {
				a.addClickHandler(handler);
			}
		}
	}

	public void setHref(String href) {
		centerText.setHref(href);
		if (anchors != null) {
			for (Anchor a : anchors) {
				a.setHref(href);
			}
		}
	}

	public FocusPanel getDragHandle() {
		return dragHandleWrapper;
	}
}
