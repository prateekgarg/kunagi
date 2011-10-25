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
package scrum.client.core;

import ilarkesto.core.base.Str;
import ilarkesto.core.base.Utl;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.AViewEditWidget;
import ilarkesto.gwt.client.AViewEditWidget.ModeSwitchHandler;
import ilarkesto.gwt.client.editor.RichtextEditorWidget;
import scrum.client.admin.ProjectUserConfig;

import com.google.gwt.user.client.Timer;

public class RichtextAutosaver extends GRichtextAutosaver implements ApplicationStartedHandler {

	public static final int SAVE_INTERVAL_IN_SECONDS = 10;

	@Override
	public void onApplicationStarted(ApplicationStartedEvent event) {
		new Timer() {

			@Override
			public void run() {
				autosave();
			}
		}.scheduleRepeating(SAVE_INTERVAL_IN_SECONDS * 1000);
		AViewEditWidget.setGlobalModeSwitchHandler(new ModeSwitchHandler() {

			@Override
			public void onViewerActivated(AViewEditWidget widget) {
				if (widget instanceof RichtextEditorWidget) {
					RichtextEditorWidget editor = (RichtextEditorWidget) widget;
					clearText(editor.getId());
				}
			}

			@Override
			public void onEditorActivated(AViewEditWidget widget) {
				if (widget instanceof RichtextEditorWidget) {
					RichtextEditorWidget editor = (RichtextEditorWidget) widget;
					String text = getText(editor.getId());
					if (!Str.isBlank(text)) {
						editor.setRestoreText(text);
					}
				}
			}
		});
	}

	public String getText(String field) {
		ProjectUserConfig config = Scope.get().getComponent(ProjectUserConfig.class);
		return config == null || !config.isRichtextAutosaveField(field) ? null : config.getRichtextAutosaveText();
	}

	public void clearText(String field) {
		ProjectUserConfig config = Scope.get().getComponent(ProjectUserConfig.class);
		if (config == null || !config.isRichtextAutosaveField(field)) return;
		config.setRichtextAutosaveText(null);
		config.setRichtextAutosaveField(null);
	}

	public void autosave() {
		AViewEditWidget currentEditor = RichtextEditorWidget.getCurrentEditor();
		if (currentEditor == null) return;
		try {
			if (!currentEditor.isInitialized()) return;
			ProjectUserConfig config = Scope.get().getComponent(ProjectUserConfig.class);
			if (config == null) return;
			if (!(currentEditor instanceof RichtextEditorWidget)) return;
			RichtextEditorWidget editor = (RichtextEditorWidget) currentEditor;
			if (!editor.isEditMode()) return;
			String text = editor.getEditorText();
			if (Str.isBlank(text)) return;
			if (text == null || text.length() < 3) return;
			if (Utl.equals(text, editor.getModel().getValue())) return;
			config.setRichtextAutosaveText(text);
			config.setRichtextAutosaveField(editor.getId());
		} catch (Throwable ex) {
			log.error(ex);
		}
	}

}
