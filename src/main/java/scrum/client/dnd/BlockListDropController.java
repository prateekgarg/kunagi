package scrum.client.dnd;

import scrum.client.common.ABlockWidget;
import scrum.client.common.BlockListWidget;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.user.client.ui.Widget;

public class BlockListDropController implements DropController {

	private BlockListWidget list;

	public BlockListDropController(BlockListWidget list) {
		this.list = list;
	}

	@Override
	public Widget getDropTarget() {
		return list;
	}

	@Override
	public void onDrop(DragContext context) {
		if (!isDropAllowed(context.draggable)) return;

		list.drop((ABlockWidget) context.draggable, 0);
	}

	@Override
	public void onEnter(DragContext context) {
		if (!isDropAllowed(context.draggable)) return;
		list.activateDrop();
	}

	@Override
	public void onLeave(DragContext context) {
		list.deactivateDndMarkers();
	}

	@Override
	public void onMove(DragContext context) {}

	@Override
	public void onPreviewDrop(DragContext context) throws VetoDragException {}

	private boolean isDropAllowed(Widget draggable) {
		if (draggable instanceof ABlockWidget) {
			ABlockWidget block = (ABlockWidget) draggable;
			if (block.getList() == list) return false;
			return list.acceptsDrop(block);
		}
		return false;
	}

}
