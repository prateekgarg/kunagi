package scrum.client.release;

import ilarkesto.gwt.client.Date;
import scrum.client.common.TooltipBuilder;

public class UnreleaseReleaseAction extends GUnreleaseReleaseAction {

	public UnreleaseReleaseAction(scrum.client.release.Release release) {
		super(release);
	}

	@Override
	public String getLabel() {
		return "Mark as planned";
	}

	@Override
	public String getTooltip() {
		TooltipBuilder tb = new TooltipBuilder("Mark this release as not published and not available to the users.");

		if (!getCurrentProject().isScrumTeamMember(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_SCRUMTEAM);

		return tb.getTooltip();
	}

	@Override
	public boolean isPermitted() {
		if (!release.getProject().isScrumTeamMember(getCurrentUser())) return false;
		return true;
	}

	@Override
	public boolean isExecutable() {
		if (!release.isReleased()) return false;
		return true;
	}

	@Override
	protected void onExecute() {
		Date previousDate = release.getReleaseDate();
		release.setReleaseDate(Date.today());
		release.setReleased(false);
		addUndo(new Undo(previousDate));
	}

	class Undo extends ALocalUndo {

		private Date date;

		public Undo(Date date) {
			super();
			this.date = date;
		}

		@Override
		public String getLabel() {
			return "Undo Mark as planned " + release.getReference() + " " + release.getLabel();
		}

		@Override
		protected void onUndo() {
			release.setReleaseDate(date);
			release.setReleased(true);
		}

	}
}