/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package scrum.server.common;

import ilarkesto.base.Sys;
import ilarkesto.gwt.server.ADesktopHtmlPageBuilder;
import ilarkesto.io.DynamicClassLoader;

public abstract class AKunagiHtmlPageBuilder extends ADesktopHtmlPageBuilder {

	@Override
	protected String getCss() {
		if (!Sys.isDevelopmentMode()) return new KunagiDesktopCssBuilder().toString();

		try {
			ClassLoader loader = new DynamicClassLoader(getClass().getClassLoader(), KunagiDesktopCssBuilder.class.getName());
			Class type = loader.loadClass(KunagiDesktopCssBuilder.class.getName());
			return type.newInstance().toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String getBodyId() {
		return "goon";
	}

}
