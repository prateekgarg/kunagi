package scrum.server.release;

import ilarkesto.base.time.Date;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import scrum.client.common.ReferenceSupport;
import scrum.server.admin.User;
import scrum.server.common.Numbered;
import scrum.server.issues.Issue;

public class Release extends GRelease implements Numbered, ReferenceSupport {

	public boolean isMajor() {
		return !isBugfix();
	}

	public boolean isBugfix() {
		return isParentReleaseSet();
	}

	public List<Issue> getIssues() {
		List<Issue> ret = new ArrayList<Issue>();
		ret.addAll(getAffectedIssues());
		ret.addAll(getFixIssues());
		return ret;
	}

	@Override
	public void updateNumber() {
		if (getNumber() == 0) setNumber(getProject().generateReleaseNumber());
	}

	@Override
	public String getReference() {
		return scrum.client.release.Release.REFERENCE_PREFIX + getNumber();
	}

	public String getReferenceAndLabel() {
		return getReference() + " " + getLabel();
	}

	@Override
	public boolean isVisibleFor(User user) {
		return getProject().isVisibleFor(user);
	}

	public boolean isEditableBy(User user) {
		return getProject().isEditableBy(user);
	}

	@Override
	public String toString() {
		return getReferenceAndLabel();
	}

	@Override
	public void ensureIntegrity() {
		super.ensureIntegrity();
		updateNumber();
	}

	public static final Comparator<Release> DATE_COMPARATOR = new Comparator<Release>() {

		@Override
		public int compare(Release ra, Release rb) {
			Date a = ra.getReleaseDate();
			Date b = rb.getReleaseDate();
			if (a == null && b == null) return 0;
			if (a == null) return 1;
			if (b == null) return -1;
			return a.compareTo(b);
		}
	};

	public static final Comparator<Release> DATE_REVERSE_COMPARATOR = new Comparator<Release>() {

		@Override
		public int compare(Release ra, Release rb) {
			return -DATE_COMPARATOR.compare(ra, rb);
		}
	};

}