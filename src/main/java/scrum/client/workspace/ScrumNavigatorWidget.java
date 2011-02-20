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

import ilarkesto.core.base.Str;
import ilarkesto.core.menu.MenuItem;
import ilarkesto.core.menu.StaticMenuItem;
import ilarkesto.core.scope.Scope;
import ilarkesto.gwt.client.SwitchingNavigatorWidget;
import scrum.client.collaboration.WikiWidget;
import scrum.client.impediments.ImpedimentListWidget;
import scrum.client.pr.BlogWidget;
import scrum.client.project.ProductBacklogWidget;
import scrum.client.tasks.WhiteboardWidget;

import com.google.gwt.user.client.ui.Widget;

public class ScrumNavigatorWidget extends SwitchingNavigatorWidget {

	public ScrumNavigatorWidget() {
		super(Scope.get().getComponent(Ui.class).getWorkspace().getWorkarea());
	}

	@Override
	protected void showItem(Widget widget) {
		String page = Str.getSimpleName(widget.getClass());
		page = Str.removeSuffix(page, "Widget");
		super.showItem(widget);
	}

	@Override
	protected String getHref(MenuItem item) {
		if (item instanceof StaticMenuItem) {
			StaticMenuItem staticItem = (StaticMenuItem) item;
			Object payload = staticItem.getPayload();
			if ("sprint".equals(payload)) return Navigator.getPageHref(WhiteboardWidget.class);
			if ("product".equals(payload)) return Navigator.getPageHref(ProductBacklogWidget.class);
			if ("project".equals(payload)) return Navigator.getPageHref(ImpedimentListWidget.class);
			if ("collaboration".equals(payload)) return Navigator.getPageHref(WikiWidget.class);
			if ("administration".equals(payload)) return Navigator.getPageHref(BlogWidget.class);
			if (payload instanceof Widget) return Navigator.getPageHref(((Widget) payload).getClass());
		}
		return super.getHref(item);
	}
}
