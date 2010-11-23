package scrum.client.common;

import ilarkesto.core.base.Str;
import ilarkesto.gwt.client.AAction;
import ilarkesto.gwt.client.AMultiSelectionViewEditWidget;
import ilarkesto.gwt.client.HyperlinkWidget;

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
		setViewerItems(model.getThemes(), ", ");
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
				getEditor().add(theme);
				getEditor().addSelected(theme);
			}
		}
	}

}
