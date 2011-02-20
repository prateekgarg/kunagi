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
package scrum.client.admin;

import ilarkesto.gwt.client.Gwt;
import ilarkesto.gwt.client.editor.TextEditorWidget;
import scrum.client.common.AScrumWidget;
import scrum.client.common.FieldsWidget;
import scrum.client.workspace.PagePanel;

import com.google.gwt.user.client.ui.Widget;

public class ProjectUserConfigWidget extends AScrumWidget {

	private FieldsWidget fields;
	private UserConfigWidget globalUserConfig;

	@Override
	protected Widget onInitialization() {
		final ProjectUserConfig config = getCurrentUser().getProjectConfig();

		fields = new FieldsWidget();
		fields.add("Color", new TextEditorWidget(config.getColorModel()) {

			@Override
			protected void onViewerUpdate() {
				super.onViewerUpdate();
				getViewer().getElement().getStyle().setProperty("color", config.getColor());
			}
		});

		globalUserConfig = new UserConfigWidget();
		PagePanel page = new PagePanel();
		page.addHeader("Personal preferences for current project");
		page.addSection(fields);
		return Gwt.createFlowPanel(page, globalUserConfig);
	}

}
