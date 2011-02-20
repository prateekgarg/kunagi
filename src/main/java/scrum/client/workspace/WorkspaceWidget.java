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
package scrum.client.workspace;

import ilarkesto.core.logging.Log;
import ilarkesto.gwt.client.FullscreenPanel;
import ilarkesto.gwt.client.Gwt;
import ilarkesto.gwt.client.LockWidget;
import ilarkesto.gwt.client.SwitcherWidget;
import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

public class WorkspaceWidget extends AScrumWidget {

	private static final Log LOG = Log.get(WorkspaceWidget.class);

	public static final int HEADER_HEIGHT = 25;

	private LockWidget locker;
	private LockInfoWidget lockInfo;
	private SwitcherWidget sidebar;
	private SwitcherWidget workarea = new SwitcherWidget(true);

	@Override
	protected Widget onInitialization() {
		setHeight100();

		lockInfo = new LockInfoWidget();
		HeaderWidget header = new HeaderWidget();
		sidebar = new SwitcherWidget(true);
		workarea.setStyleName("Workspace-body-center-content");

		ScrollPanel workareaScroller = new ScrollPanel(Gwt.createDiv("Workspace-body-center-content", workarea));
		workareaScroller.getElement().setId("workarea-scroller");
		workareaScroller.setHeight("100%");
		workarea.setScrollPanel(workareaScroller);

		FlowPanel body = new FlowPanel();
		body.setStyleName("Workspace-body");
		body.add(Gwt.createDiv("Workspace-body-west", sidebar));
		body.add(Gwt.createDiv("Workspace-body-center", workareaScroller));

		FlowPanel workspace = Gwt.createFlowPanel(Gwt.createDiv("Workspace-header", header), body);
		workspace.setStyleName("Workspace");

		locker = new LockWidget(workspace);

		return new FullscreenPanel(locker);
	}

	@Override
	protected void onUpdate() {
		LOG.debug("Updating UI");
		super.onUpdate();
	}

	public void abort(String message) {
		Log.DEBUG("Locking UI for ABORT:", message);
		lockInfo.showBug(message + " Restarting your session...");
		locker.lock(lockInfo);
		Gwt.runLater(20000, new Runnable() {

			@Override
			public void run() {
				Window.Location.reload();
			}

		});
	}

	public void lock(String message) {
		initialize();
		Log.DEBUG("Locking UI:", message);
		lockInfo.showWait(message);
		locker.lock(lockInfo);
	}

	public void unlock() {
		Log.DEBUG("Unlocking UI");
		locker.unlock();
	}

	public void showError(String message) {
		final DialogBox db = new DialogBox();
		db.setSize("200", "150");
		db.setPopupPosition(100, 100);

		FlowPanel panel = new FlowPanel();
		Label text = new Label(message);
		panel.add(text);

		Button close = new Button("close");
		close.addClickListener(new ClickListener() {

			@Override
			public void onClick(Widget sender) {
				db.hide();
			}
		});
		panel.add(close);

		db.add(panel);
		db.show();
	}

	public SwitcherWidget getWorkarea() {
		return workarea;
	}

	public SwitcherWidget getSidebar() {
		return sidebar;
	}

}
