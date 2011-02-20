/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.client.release;

import ilarkesto.gwt.client.ButtonWidget;
import scrum.client.common.AScrumWidget;
import scrum.client.common.BlockListSelectionManager;
import scrum.client.common.BlockListWidget;
import scrum.client.common.UserGuideWidget;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class ReleaseManagementWidget extends AScrumWidget {

	public BlockListWidget<Release> planned;
	public BlockListWidget<Release> published;
	private BlockListSelectionManager selectionManager;

	@Override
	protected Widget onInitialization() {
		selectionManager = new BlockListSelectionManager();

		planned = new BlockListWidget<Release>(ReleaseBlock.FACTORY);
		planned.setSelectionManager(selectionManager);
		planned.setAutoSorter(Release.DATE_COMPARATOR);

		published = new BlockListWidget<Release>(ReleaseBlock.FACTORY);
		published.setSelectionManager(selectionManager);
		published.setAutoSorter(Release.DATE_REVERSE_COMPARATOR);

		PagePanel page = new PagePanel();
		page.addHeader("Planned releases", new ButtonWidget(new CreateReleaseAction()));
		page.addSection(planned);
		page.addHeader("Published releases");
		page.addSection(published);
		page.addSection(new UserGuideWidget(getLocalizer().views().releases(),
				getCurrentProject().getReleases().size() < 5, getCurrentUser().getHideUserGuideReleasesModel()));
		return page;
	}

	@Override
	protected void onUpdate() {
		planned.setObjects(getCurrentProject().getPlannedReleases());
		published.setObjects(getCurrentProject().getReleasedReleases());
		super.onUpdate();
	}

	public boolean select(Release release) {
		update();
		return selectionManager.select(release);
	}

}
