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
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.server.issues;

import ilarkesto.core.base.Str;
import ilarkesto.core.time.Date;
import ilarkesto.pdf.APdfContainerElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scrum.server.common.APdfCreator;
import scrum.server.project.Project;

public class BugListPdfCreator extends APdfCreator {

	public BugListPdfCreator(Project project) {
		super(project);
	}

	@Override
	protected void build(APdfContainerElement pdf) {
		reportHeader(pdf, "Bug-Issues", project.getLabel());

		List<Issue> issues = new ArrayList<Issue>(project.getIssues());
		Collections.sort(issues, Issue.SEVERITY_COMPARATOR);
		for (Issue issue : issues) {
			if (issue.isClosed()) continue;
			if (!issue.isBug()) continue;
			issue(pdf, issue);
		}
	}

	@Override
	protected String getFilename() {
		return "kunagi-issues_" + Date.today().toString() + "_" + Str.toFileCompatibleString(project.getLabel());
	}

}
