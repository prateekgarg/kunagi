package scrum.client.common;

import ilarkesto.gwt.client.AMultiSelectionViewEditWidget;
import ilarkesto.gwt.client.editor.AEditorModel;

public class WeekdaySelectorEditorWidget extends AMultiSelectionViewEditWidget<Integer> {

	private AEditorModel<WeekdaySelector> model;

	public WeekdaySelectorEditorWidget(AEditorModel<WeekdaySelector> editor) {
		super();
		this.model = editor;
	}

	@Override
	protected void onViewerUpdate() {
		setViewerItems(model.getValue().getWeekdaysLong(), ", ");
	}

	@Override
	protected void onEditorUpdate() {
		setEditorItems(WeekdaySelector.INDEXES);
		setEditorSelectedItems(model.getValue().getWeekdaysIndexes());
	}

	@Override
	protected void onEditorSubmit() {
		model.setValue(new WeekdaySelector(getEditorSelectedItems()));
	}

	@Override
	protected String toHtml(Integer weekday) {
		switch (weekday) {
			case 1:
				return "Sunday";
			case 2:
				return "Monday";
			case 3:
				return "Tuesday";
			case 4:
				return "Wednesday";
			case 5:
				return "Thursday";
			case 6:
				return "Friday";
			case 7:
				return "Saturday";
		}
		return weekday.toString();
	}

	@Override
	public boolean isEditable() {
		return model.isEditable();
	}

	@Override
	public String getTooltip() {
		return model.getTooltip();
	}

	@Override
	public String getId() {
		return model.getId();
	}

}
