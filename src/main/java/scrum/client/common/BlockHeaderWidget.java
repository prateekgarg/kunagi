package scrum.client.common;

import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.AWidget;
import ilarkesto.gwt.client.AnchorPanel;
import ilarkesto.gwt.client.ButtonWidget;
import ilarkesto.gwt.client.DropdownMenuButtonWidget;
import ilarkesto.gwt.client.editor.AFieldModel;
import ilarkesto.gwt.client.editor.TextOutputWidget;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class BlockHeaderWidget extends AWidget {

	private HorizontalPanel table;
	private FocusPanel dragHandleWrapper;
	private AnchorPanel centerWrapper;

	private DropdownMenuButtonWidget menu;
	private Label dragHandle;

	@Override
	protected Widget onInitialization() {
		dragHandleWrapper = new FocusPanel();
		dragHandleWrapper.setStyleName("BlockHeaderWidget-dragHandle");
		// dragHandleWrapper.setHeight("100%");

		centerWrapper = new AnchorPanel();
		centerWrapper.setStyleName("BlockHeaderWidget-anchor");
		centerWrapper.setWidth("100%");

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
		centerWrapper.setFocus(false);
	}

	public void addText(AFieldModel<?> model) {
		addText(model, null, false, false);
	}

	public void addText(AFieldModel<?> model, boolean secondary) {
		addText(model, null, secondary, secondary);
	}

	public void addText(AFieldModel<?> model, String width, boolean secondary, boolean small) {
		centerWrapper.add(createCell(new TextOutputWidget(model), secondary, small, width));
	}

	// ---

	public SimplePanel addIconWrapper() {
		SimplePanel cell = createCell(null, false, false, "BlockHeaderWidget-prefixIcon");
		cell.setHeight("16px");
		cell.getElement().getStyle().setMarginTop(2, Unit.PX);
		return cell;
	}

	public void appendCell(Widget widget, String width, boolean alignRight) {
		table.add(widget);
		if (alignRight) table.setCellHorizontalAlignment(widget, HorizontalPanel.ALIGN_RIGHT);
		if (width != null) table.setCellWidth(widget, width);
	}

	private SimplePanel createCell(Widget widget, boolean secondary, boolean small, String additionalStyleName) {
		SimplePanel wrapper = new SimplePanel();
		wrapper.setStyleName("BlockHeaderWidget-cell");
		wrapper.setHeight("100%");
		if (secondary) wrapper.addStyleName("BlockHeaderWidget-cell-secondary");
		if (small) wrapper.addStyleName("BlockHeaderWidget-cell-small");
		if (additionalStyleName != null) wrapper.addStyleName(additionalStyleName);
		wrapper.setWidget(widget);
		return wrapper;
	}

	public void addMenuAction(AScrumAction action) {
		if (menu == null) {
			menu = new DropdownMenuButtonWidget();
			appendCell(menu, "30px", true);
		}
		menu.addAction(action);
	}

	public void addToolbarAction(AAction action) {
		appendCell(new ButtonWidget(action), "5px", true);
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

	public void addClickHandler(ClickHandler handler) {
		centerWrapper.addClickHandler(handler);
	}

	public void setHref(String href) {
		centerWrapper.setHref(href);
	}

	public FocusPanel getDragHandle() {
		return dragHandleWrapper;
	}
}
