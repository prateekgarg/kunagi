package scrum.client.impediments;

import scrum.client.collaboration.EmoticonsWidget;
import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;
import scrum.client.img.Img;
import scrum.client.journal.ActivateChangeHistoryAction;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class ImpedimentBlock extends ABlockWidget<Impediment> implements TrashSupport {

	private SimplePanel statusIcon;

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Impediment impediment = getObject();
		header.addText(impediment.getDateModel(), "70px", true, true);
		statusIcon = header.addIconWrapper();
		header.addText(impediment.getLabelModel());
		header.appendCell(new EmoticonsWidget(impediment), null, true);
		header.addMenuAction(new ActivateChangeHistoryAction(impediment));
		header.addMenuAction(new CloseImpedimentAction(impediment));
		header.addMenuAction(new DeleteImpedimentAction(impediment));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		Impediment impediment = getObject();
		header.setDragHandle(impediment.getReference());
		Image statusImage = null;
		if (impediment.isOpen()) {
			statusImage = Img.bundle.impOpen().createImage();
			statusImage.setTitle("Still impeding.");
		}
		statusIcon.setWidget(statusImage);
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new ImpedimentWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		return new DeleteImpedimentAction(getObject());
	}

	public static final BlockWidgetFactory<Impediment> FACTORY = new BlockWidgetFactory<Impediment>() {

		@Override
		public ImpedimentBlock createBlock() {
			return new ImpedimentBlock();
		}

	};

}
