package scrum.client.risks;

import scrum.client.collaboration.EmoticonsWidget;
import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;
import scrum.client.journal.ActivateChangeHistoryAction;

import com.google.gwt.user.client.ui.Widget;

public class RiskBlock extends ABlockWidget<Risk> implements TrashSupport {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Risk risk = getObject();
		header.addText(risk.getPriorityLabelModel(), "100px", true, false);
		header.addText(risk.getLabelModel());
		header.appendCell(new EmoticonsWidget(risk), null, true);
		header.addMenuAction(new ActivateChangeHistoryAction(risk));
		header.addMenuAction(new DeleteRiskAction(risk));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		Risk risk = getObject();
		header.setDragHandle(risk.getReference());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new RiskWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		return new DeleteRiskAction(getObject());
	}

	public static final BlockWidgetFactory<Risk> FACTORY = new BlockWidgetFactory<Risk>() {

		@Override
		public RiskBlock createBlock() {
			return new RiskBlock();
		}
	};
}
