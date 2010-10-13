package scrum.client.collaboration;

import ilarkesto.core.base.Str;
import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.AViewEditWidget;
import ilarkesto.gwt.client.Gwt;
import ilarkesto.gwt.client.HyperlinkWidget;
import ilarkesto.gwt.client.TableBuilder;
import ilarkesto.gwt.client.editor.ATextEditorModel;
import ilarkesto.gwt.client.editor.RichtextEditorWidget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import scrum.client.common.AScrumGwtEntity;
import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

public class CommentsWidget extends AScrumWidget {

	private static final int COMMENTS_PER_PAGE = 5;

	private FlowPanel containerPanel;
	private AScrumGwtEntity parent;
	private Map<Comment, CommentWidget> widgets;

	private HyperlinkWidget activateCommentLink;
	private RichtextEditorWidget editor;

	private int currentPage = 1;

	public CommentsWidget(AScrumGwtEntity parent) {
		this.parent = parent;
	}

	@Override
	protected Widget onInitialization() {
		new RequestCommentsServiceCall(parent.getId()).execute(); // TODO commentsManagerComponent

		activateCommentLink = new HyperlinkWidget(new ActivateCommentEditorAction());

		widgets = new HashMap<Comment, CommentWidget>();

		containerPanel = new FlowPanel();
		containerPanel.setStyleName("CommentsWidget");

		return containerPanel;
	}

	@Override
	protected void onUpdate() {
		containerPanel.clear();

		if (this.editor == null) {
			containerPanel.add(activateCommentLink);
		} else {
			containerPanel.add(this.editor);
		}

		List<Comment> comments = parent.getComments();
		Collections.sort(comments, Comment.REVERSE_DATEANDTIME_COMPARATOR);
		List<Comment> pageComments = filterCurrentPageComments(comments);
		for (Comment comment : pageComments) {
			CommentWidget widget = getWidget(comment);
			containerPanel.add(widget);
		}

		if (comments.size() > COMMENTS_PER_PAGE) {
			containerPanel.add(createPageNavigator(comments.size()));
		}

		super.onUpdate();
	}

	private Widget createPageNavigator(int commentCount) {
		TableBuilder tb = new TableBuilder();
		tb.setWidth(null);
		tb.addFieldLabel("Pages:");
		int page = 1;
		int endIdx = COMMENTS_PER_PAGE - 1;
		if (currentPage > 1) {
			tb.addSpacer(5, 1);
			tb.add(Gwt.createDiv("CommentsWidget-pageNavigator-page", new HyperlinkWidget(new ShowPageAction("<",
					currentPage - 1))));
			tb.addSpacer(5, 1);
		}
		while (true) {
			tb.addSpacer(5, 1);
			if (currentPage == page) {
				tb.add(Gwt.createDiv("CommentsWidget-pageNavigator-currentPage", String.valueOf(page)));
			} else {
				tb.add(Gwt.createDiv("CommentsWidget-pageNavigator-page",
					new HyperlinkWidget(new ShowPageAction(String.valueOf(page), page))));
			}
			if (endIdx >= commentCount - 1) break;
			page++;
			endIdx += COMMENTS_PER_PAGE;
		}
		if (page > currentPage) {
			tb.addSpacer(10, 1);
			tb.add(Gwt.createDiv("CommentsWidget-pageNavigator-page", new HyperlinkWidget(new ShowPageAction(">",
					currentPage + 1))));
		}
		return Gwt.createDiv("CommentsWidget-pageNavigator", tb.createTable());
	}

	private List<Comment> filterCurrentPageComments(List<Comment> comments) {
		List<Comment> ret = new ArrayList<Comment>(COMMENTS_PER_PAGE);
		int startIdx = (currentPage - 1) * COMMENTS_PER_PAGE;
		int endIdx = startIdx + COMMENTS_PER_PAGE - 1;
		if (endIdx >= comments.size()) endIdx = comments.size() - 1;
		for (int i = startIdx; i <= endIdx; i++) {
			ret.add(comments.get(i));
		}
		return ret;
	}

	private CommentWidget getWidget(Comment comment) {
		CommentWidget widget = widgets.get(comment);
		if (widget == null) {
			widget = new CommentWidget(comment);
			widgets.put(comment, widget);
		}
		return widget;
	}

	private void postComment() {
		String text = editor.getEditorText();
		if (Str.isBlank(text)) return;
		text = text.trim();
		Comment comment = new Comment(parent, getAuth().getUser(), text);
		getDao().createComment(comment);
		update();
	}

	private void activateEditor() {
		this.editor = new RichtextEditorWidget(new ATextEditorModel() {

			@Override
			public void setValue(String text) {
				postComment();
			}

			@Override
			public String getValue() {
				return null;
			}
		});
		this.editor.switchToEditMode();
		this.editor.setModeSwitchHandler(new AViewEditWidget.ModeSwitchHandler() {

			@Override
			public void onViewerActivated(AViewEditWidget widget) {
				editor = null;
				update();
			}

			@Override
			public void onEditorActivated(AViewEditWidget widget) {}
		});
		update();
	}

	private class ActivateCommentEditorAction extends AAction {

		@Override
		public String getLabel() {
			return "Create a comment...";
		}

		@Override
		protected void onExecute() {
			activateEditor();
		}

	}

	private class ShowPageAction extends AAction {

		private String label;
		private int page;

		public ShowPageAction(String label, int page) {
			super();
			this.label = label;
			this.page = page;
		}

		@Override
		public String getLabel() {
			return label;
		}

		@Override
		public String getTooltip() {
			return "Show page " + page;
		}

		@Override
		protected void onExecute() {
			currentPage = page;
			update();
		}
	}

}
