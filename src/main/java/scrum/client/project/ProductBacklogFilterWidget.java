package scrum.client.project;

import java.util.ArrayList;
import java.util.List;

import scrum.client.common.AScrumWidget;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ProductBacklogFilterWidget extends AScrumWidget {

	public List<Requirement> getRequirements() {
		List<Requirement> ret = new ArrayList<Requirement>();
		for (Requirement req : getCurrentProject().getProductBacklogRequirements()) {
			if (matches(req)) ret.add(req);
		}
		return ret;
	}

	private boolean matches(Requirement req) {
		return req.getEstimatedWork() == null;
	}

	@Override
	protected Widget onInitialization() {
		return new Label("Filter");
	}

}
