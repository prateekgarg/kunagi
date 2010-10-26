package scrum.client.calendar;

import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;

import com.google.gwt.user.client.ui.Widget;

public class SimpleEventBlock extends ABlockWidget<SimpleEvent> implements TrashSupport {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		SimpleEvent event = getObject();
		header.addText(event.getTimeModel(), "35px", true, true);
		header.addText(event.getLabelModel());
		header.addText(event.getDurationModel(), true);
		header.addMenuAction(new PublishSimpleEventAction(event));
		header.addMenuAction(new DeleteSimpleEventAction(event));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		SimpleEvent event = getObject();
		header.setDragHandle(event.getReference());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new SimpleEventWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		return new DeleteSimpleEventAction(getObject());
	}

	public static final BlockWidgetFactory<SimpleEvent> FACTORY = new BlockWidgetFactory<SimpleEvent>() {

		@Override
		public SimpleEventBlock createBlock() {
			return new SimpleEventBlock();
		}

	};

}
