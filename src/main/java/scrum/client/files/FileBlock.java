package scrum.client.files;

import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;

import com.google.gwt.user.client.ui.Widget;

public class FileBlock extends ABlockWidget<File> implements TrashSupport {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		File file = getObject();
		header.addText(file.getLabelModel());
		header.addText(file.getUploadTimeModel(), true);
		header.addMenuAction(new DeleteFileAction(file));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		File file = getObject();
		header.setDragHandle(file.getReference());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new FileWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		return new DeleteFileAction(getObject());
	}

	public static final BlockWidgetFactory<File> FACTORY = new BlockWidgetFactory<File>() {

		@Override
		public FileBlock createBlock() {
			return new FileBlock();
		}

	};

}
