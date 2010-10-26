package scrum.client.release;

import ilarkesto.gwt.client.Date;
import ilarkesto.gwt.client.editor.AFieldModel;
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

public class ReleaseBlock extends ABlockWidget<Release> implements TrashSupport {

	private SimplePanel typeIcon;

	@Override
	protected void onInitializationHeader(BlockHeaderWidget header) {
		Release release = getObject();
		typeIcon = header.addIconWrapper();
		header.addText(release.getLabelModel());
		header.addText(createDateSuffixModel(), true);
		header.addText(release.getParentReleaseLabelModel(), true);
		header.appendCell(new EmoticonsWidget(release), null, true);
		header.addMenuAction(new CreateBugfixReleaseAction(release));
		header.addMenuAction(new ReleaseReleaseAction(release));
		header.addMenuAction(new UnreleaseReleaseAction(release));
		header.addMenuAction(new CreateBlogEntryAction(release));
		header.addMenuAction(new ActivateChangeHistoryAction(release));
		header.addMenuAction(new DeleteReleaseAction(release));
	}

	@Override
	protected void onUpdateHeader(BlockHeaderWidget header) {
		Release release = getObject();
		typeIcon.setWidget(createTypeIcon());
		header.setDragHandle(release.getReference());
	}

	private Image createTypeIcon() {
		Release release = getObject();
		Image image;
		if (release.isBugfix()) {
			image = Img.bundle.bugfixRelease().createImage();
			image.setTitle("Bugfix Release");
		} else {
			image = Img.bundle.majorRelease().createImage();
			image.setTitle("Major Release");
		}
		return image;
	}

	private AFieldModel<String> createDateSuffixModel() {
		return new AFieldModel<String>() {

			@Override
			public String getValue() {
				Release release = getObject();
				String dateSuffix = null;
				Date date = release.getReleaseDate();
				if (date != null) {
					dateSuffix = date.toString();
					Date today = Date.today();
					if (date.isAfter(today)) {
						dateSuffix += " (in " + today.getPeriodTo(date).toDays() + " days)";
					} else if (date.isBefore(today)) {
						dateSuffix += " (" + date.getPeriodTo(today).toShortestString() + " ago)";
					} else {
						dateSuffix += " (today)";
					}
				} else {
					dateSuffix = "unscheduled";
				}
				return dateSuffix;
			}
		};
	}

	@Override
	protected Widget onExtendedInitialization() {
		return new ReleaseWidget(getObject());
	}

	@Override
	public AScrumAction getTrashAction() {
		return new DeleteReleaseAction(getObject());
	}

	public static final BlockWidgetFactory<Release> FACTORY = new BlockWidgetFactory<Release>() {

		@Override
		public ReleaseBlock createBlock() {
			return new ReleaseBlock();
		}
	};
}
