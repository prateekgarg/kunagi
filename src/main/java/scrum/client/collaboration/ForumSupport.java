package scrum.client.collaboration;

import ilarkesto.gwt.client.DateAndTime;
import ilarkesto.gwt.client.editor.AFieldModel;

import java.util.Comparator;

import scrum.client.common.AScrumGwtEntity;
import scrum.client.common.LabelSupport;
import scrum.client.common.ReferenceSupport;

import com.google.gwt.user.client.ui.Widget;

public interface ForumSupport extends LabelSupport, ReferenceSupport {

	Widget createForumItemWidget();

	public static final Comparator<ForumSupport> COMPARATOR = new Comparator<ForumSupport>() {

		@Override
		public int compare(ForumSupport aFs, ForumSupport bFs) {
			DateAndTime aTime = ((AScrumGwtEntity) aFs).getLatestCommentDateAndTime();
			DateAndTime bTime = ((AScrumGwtEntity) bFs).getLatestCommentDateAndTime();
			if (aTime == null && bTime == null) return 0;
			if (aTime == null) return -1;
			if (bTime == null) return 1;
			return bTime.compareTo(aTime);
		}
	};

	AFieldModel<String> getLabelModel();

	AFieldModel<String> getLastCommentAgoModel();
}
