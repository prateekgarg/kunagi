package scrum.client.collaboration;

import scrum.client.common.ABlockWidget;
import scrum.client.common.AScrumAction;
import scrum.client.common.BlockHeaderWidget;
import scrum.client.common.BlockWidgetFactory;
import scrum.client.dnd.TrashSupport;

import com.google.gwt.user.client.ui.Widget;

public class ForumItemBlock extends ABlockWidget<ForumSupport> implements TrashSupport {

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		ForumSupport entity = getObject();
		header.addText(entity.getLabelModel());
		header.addText(entity.getLastCommentAgoModel(), true);
		if (entity instanceof Subject) {
			header.addMenuAction(new DeleteSubjectAction((Subject) entity));
		}
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		ForumSupport entity = getObject();
		header.setDragHandle(entity.getReference());
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new ForumItemWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		ForumSupport entity = getObject();
		if (entity instanceof Subject) return new DeleteSubjectAction((Subject) entity);
		return null;
	}

	public static final BlockWidgetFactory<ForumSupport> FACTORY = new BlockWidgetFactory<ForumSupport>() {

		@Override
		public ForumItemBlock createBlock() {
			return new ForumItemBlock();
		}

	};

}
