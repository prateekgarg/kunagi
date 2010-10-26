package scrum.client.pr;

import ilarkesto.core.base.Utl;
import ilarkesto.gwt.client.DateAndTime;
import ilarkesto.gwt.client.HyperlinkWidget;
import ilarkesto.gwt.client.editor.AFieldModel;

import java.util.Comparator;
import java.util.Map;

import scrum.client.ScrumGwt;
import scrum.client.collaboration.ForumSupport;
import scrum.client.common.ReferenceSupport;
import scrum.client.common.ShowEntityAction;
import scrum.client.project.Project;

import com.google.gwt.user.client.ui.Widget;

public class BlogEntry extends GBlogEntry implements ReferenceSupport, ForumSupport {

	public static final String REFERENCE_PREFIX = "blg";

	public BlogEntry(Map data) {
		super(data);
	}

	public BlogEntry(Project project) {
		setProject(project);
	}

	@Override
	public String getReference() {
		return REFERENCE_PREFIX + getNumber();
	}

	@Override
	public String getLabel() {
		return getTitle();
	}

	@Override
	public String toHtml() {
		return ScrumGwt.toHtml(this, getTitle());
	}

	@Override
	public String toString() {
		return getReference() + " " + getTitle();
	}

	@Override
	public Widget createForumItemWidget() {
		return new HyperlinkWidget(new ShowEntityAction(this, getLabel()));
	}

	public static final Comparator<BlogEntry> DATE_COMPARATOR = new Comparator<BlogEntry>() {

		@Override
		public int compare(BlogEntry a, BlogEntry b) {
			return Utl.compare(b.getDateAndTime(), a.getDateAndTime());
		}
	};

	private AFieldModel<String> dateModel;

	public AFieldModel<String> getDateModel() {
		if (dateModel == null) dateModel = new AFieldModel<String>() {

			@Override
			public String getValue() {
				DateAndTime dateAndTime = getDateAndTime();
				return dateAndTime != null ? dateAndTime.getDate().toString() : null;
			}
		};
		return dateModel;
	}
}