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
package scrum.client.common;

import ilarkesto.core.base.Str;
import ilarkesto.core.scope.Scope;
import scrum.client.ScrumGwtApplication;

public abstract class AServiceCall {

	public abstract void execute();

	protected void onSuccess() {}

	protected void onFailure(Throwable ex) {}

	protected final ScrumGwtApplication getService() {
		return (ScrumGwtApplication) Scope.get().getComponent("app");
	}

	@Override
	public String toString() {
		return Str.getSimpleName(getClass());
	}

}
