package scrum.client.pr;

import ilarkesto.core.base.Str;
import ilarkesto.gwt.client.AMultiSelectionViewEditWidget;
import ilarkesto.gwt.client.AOutputViewEditWidget;
import ilarkesto.gwt.client.TableBuilder;
import scrum.client.ScrumGwt;
import scrum.client.admin.User;
import scrum.client.common.AScrumWidget;
import scrum.client.journal.ChangeHistoryWidget;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class BlogEntryWidget extends AScrumWidget {

	private BlogEntry blogEntry;

	public BlogEntryWidget(BlogEntry blogEntry) {
		super();
		this.blogEntry = blogEntry;
	}

	@Override
	protected Widget onInitialization() {
		TableBuilder tb = ScrumGwt.createFieldTable();

		tb.addFieldRow("Title", blogEntry.getTitleModel());
		tb.addFieldRow("Text", blogEntry.getTextModel());
		tb.addFieldRow("Date", blogEntry.getDateAndTimeModel());
		tb.addFieldRow("Authors", new AMultiSelectionViewEditWidget<User>() {

			@Override
			protected void onViewerUpdate() {
				setViewerItems(blogEntry.getAuthors());
			}

			@Override
			protected void onEditorUpdate() {
				setEditorItems(blogEntry.getProject().getParticipants());
				setEditorSelectedItems(blogEntry.getAuthors());
			}

			@Override
			protected void onEditorSubmit() {
				blogEntry.setAuthors(getEditorSelectedItems());
			}

			@Override
			public boolean isEditable() {
				return true;
			}
		});
		if (blogEntry.isPublished() && blogEntry.getProject().getHomepageDir() != null) {
			tb.addFieldRow("Public URL", new AOutputViewEditWidget() {

				@Override
				protected void onViewerUpdate() {
					String url = blogEntry.getProject().getHomepageUrl();
					if (Str.isBlank(url)) {
						setViewer(new Label("Yes"));
					} else {
						if (!url.endsWith("/")) url += "/";
						url += blogEntry.getReference() + ".html";
						setViewer(new HTML("<a href=\"" + url + "\" target=\"_blank\">" + url + "</a>"));
					}
				}
			});
		}
		tb.addRow(new ChangeHistoryWidget(blogEntry), 2);

		return TableBuilder.row(20, tb.createTable(), ScrumGwt.createEmoticonsAndComments(blogEntry));
	}
}
