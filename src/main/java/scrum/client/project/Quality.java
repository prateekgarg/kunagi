package scrum.client.project;

import ilarkesto.core.base.Utl;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.HyperlinkWidget;

import java.util.Comparator;
import java.util.Map;

import scrum.client.ScrumGwt;
import scrum.client.admin.Auth;
import scrum.client.collaboration.ForumSupport;
import scrum.client.common.ReferenceSupport;
import scrum.client.common.ShowEntityAction;
import scrum.client.issues.Issue;

import com.google.gwt.user.client.ui.Widget;

public class Quality extends GQuality implements ReferenceSupport, ForumSupport {

	public static final String REFERENCE_PREFIX = "qlt";

	public Quality(Project project) {
		setProject(project);
	}

	public Quality(Issue issue) {
		setProject(issue.getProject());
		setLabel(issue.getLabel());
		setDescription(issue.getDescription());
	}

	public Quality(Map data) {
		super(data);
	}

	@Override
	public String getReference() {
		return REFERENCE_PREFIX + getNumber();
	}

	@Override
	public String toHtml() {
		return ScrumGwt.toHtml(getReference(), getLabel());
	}

	@Override
	public String toString() {
		return getReference() + " " + getLabel();
	}

	@Override
	public boolean isEditable() {
		if (!getProject().isProductOwner(Scope.get().getComponent(Auth.class).getUser())) return false;
		return true;
	}

	@Override
	public Widget createForumItemWidget() {
		return new HyperlinkWidget(new ShowEntityAction(this, getLabel()));
	}

	public static final Comparator<Quality> LABEL_COMPARATOR = new Comparator<Quality>() {

		@Override
		public int compare(Quality a, Quality b) {
			return Utl.compare(a.getLabel(), b.getLabel());
		}
	};

}
