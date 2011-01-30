package scrum.client.project;

import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.ButtonWidget;
import ilarkesto.gwt.client.Gwt;
import scrum.client.common.AScrumWidget;
import scrum.client.workspace.DndManager;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class CreateStoryButtonWidget extends AScrumWidget {

	private FocusPanel dragHandle;
	private CreateRequirementAction action;

	@Override
	protected Widget onInitialization() {
		setStyleName("CreateStoryButtonWidget");

		action = new CreateRequirementAction();

		dragHandle = new FocusPanel(new Label("new sto"));
		Scope.get().getComponent(DndManager.class).makeDraggable(this, dragHandle);
		dragHandle.setStyleName("CreateStoryButtonWidget-dragHandle");

		return Gwt.createHorizontalPanel(0, new ButtonWidget(action), dragHandle);
	}

	public CreateRequirementAction getAction() {
		return action;
	}

	public FocusPanel getDragHandle() {
		return dragHandle;
	}

}
