package scrum.client.sprint;

import scrum.client.collaboration.EmoticonsWidget;
import scrum.client.common.ABlockWidget;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;

import com.google.gwt.user.client.ui.Widget;

public class SprintBlock extends ABlockWidget<Sprint> {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Sprint sprint = getObject();
		header.setDragHandle(sprint.getReference());
		header.addText(sprint.getBeginModel(), "150px", true, true);
		header.addText(sprint.getLabelModel());
		header.addText(sprint.getVelocityModel(), true);
		header.appendCell(new EmoticonsWidget(sprint), null, true);
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {}

	@Override
	protected Widget onExtendedInitialization() {
		return new SprintWidget(getObject());
	}

	public static final BlockWidgetFactory<Sprint> FACTORY = new BlockWidgetFactory<Sprint>() {

		@Override
		public SprintBlock createBlock() {
			return new SprintBlock();
		}
	};

}
