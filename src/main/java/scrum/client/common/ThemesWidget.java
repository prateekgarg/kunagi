/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.client.common;

import ilarkesto.core.base.Str;
import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.AMultiSelectionViewEditWidget;
import ilarkesto.gwt.client.HyperlinkWidget;
import ilarkesto.gwt.client.MultiSelectionWidget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.client.ScrumGwt;

import com.google.gwt.user.client.ui.Widget;

public class ThemesWidget extends AMultiSelectionViewEditWidget<String> {

	private ThemesContainer model;

	public ThemesWidget(ThemesContainer model) {
		super();
		this.model = model;
	}

	@Override
	protected void onViewerUpdate() {
		List<String> themes = model.getThemes();
		Collections.sort(themes);
		setViewerItems(themes, ", ");
	}

	@Override
	protected void onEditorUpdate() {
		List<String> themes = new ArrayList<String>(model.getAvailableThemes());
		Collections.sort(themes);
		setEditorItems(themes);
		setEditorSelectedItems(model.getThemes());
	}

	@Override
	protected void onEditorSubmit() {
		model.setThemes(getEditorSelectedItems());
	}

	@Override
	protected Widget getExtendedEditorContent() {
		return new HyperlinkWidget(new AddThemeAction()).update();
	}

	@Override
	public boolean isEditable() {
		return model.isThemesEditable();
	}

	class AddThemeAction extends AAction {

		@Override
		public String getLabel() {
			return "Add new Theme";
		}

		@Override
		protected void onExecute() {
			String theme = ScrumGwt.prompt("New Theme:", "");
			if (!Str.isBlank(theme)) {
				MultiSelectionWidget<String> editor = getEditor();

				List<String> items = editor.getItems();
				List<String> selected = editor.getSelected();

				items.add(theme);
				Collections.sort(items);
				selected.add(theme);

				editor.setItems(items);
				editor.setSelected(selected);
			}
		}
	}

}
