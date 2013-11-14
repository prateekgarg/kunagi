/*
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
package scrum.client.files;

import java.util.List;

import scrum.client.common.AScrumWidget;
import scrum.client.project.MoveRequirementToOtherProject;
import scrum.client.project.Project;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProjectSelectionWidget extends AScrumWidget {

	private Button button = new Button();

	private DialogBox dialog;

	protected String projectId;

	private String requirementId;

	private String currentProject;

	private MoveRequirementToOtherProject caller;

	/*
	 * Provide a new project for a requirement
	 */

	public ProjectSelectionWidget(MoveRequirementToOtherProject action, String requirementId, String currentProject) {
		this.caller = action;
		this.requirementId = requirementId;
		this.currentProject = currentProject;
	}

	@Override
	protected Widget onInitialization() {
		Panel panel = new VerticalPanel();
		List<Project> projects = getDao().getProjects();
		ListBox projectList = new ListBox();
		projectList.setVisibleItemCount(10);

		projectList.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				ListBox lb = (ListBox) event.getSource();
				projectId = lb.getValue((lb.getSelectedIndex()));
			}

		});

		projectList.addStyleName("listAvailableProjects");
		for (Project project : projects) {
			if (project.isProductOwner(getCurrentUser()) && !project.getId().equals(currentProject)) {
				projectList.addItem(project.getLabel(), project.getId());
			}
		}

		Button btnSelect = new Button("Choose Project", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (projectId != null && !projectId.trim().equals("")) {
					caller.executeMove(projectId, requirementId);
				}

				dialog.hide();
			}
		});
		btnSelect.setStyleName("btnSelectProject");

		Button btnCancel = new Button("Cancel", new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				dialog.hide();
			}
		});
		btnCancel.setStyleName("btnCancelSelectProject");

		Panel pnlButtons = new HorizontalPanel();
		pnlButtons.setStyleName("pnlSelectProject");
		pnlButtons.add(btnSelect);
		pnlButtons.add(btnCancel);

		panel.add(projectList);
		panel.add(pnlButtons);

		return panel;
	}

	@Override
	protected void onUpdate() {
		super.onUpdate();
		button.setVisible(false);
	}

	public void showDialog() {

		dialog = new DialogBox(true, true);
		dialog.setAnimationEnabled(true);
		dialog.setWidget(update());

		dialog.center();
		dialog.show();

	}

	public DialogBox getDialog() {
		return dialog;
	}
}
