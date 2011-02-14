package scrum.client.workspace.history;

import ilarkesto.core.base.Str;
import ilarkesto.core.base.Utl;
import ilarkesto.core.logging.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class HistoryToken {

	private static Log log = Log.get(HistoryToken.class);

	private HistoryTokenObserver observer;

	private String projectId;
	private String page;
	private String entityId;
	private boolean toggle;

	public HistoryToken(HistoryTokenObserver observer) {
		this.observer = observer;
		History.addValueChangeHandler(new TokenChangeHandler());
	}

	public void evalHistoryToken() {
		evalHistoryToken(History.getToken());
	}

	private void evalHistoryToken(String token) {
		log.debug("Evaluating history token:", token);
		Map<String, String> props = parseHistoryToken(token);

		String oldProjectId = projectId;
		String oldPage = page;
		String oldEntityId = entityId;

		projectId = props.get("project");
		page = props.get("page");
		entityId = props.get("entity");
		toggle = Str.isTrue(props.get("toggle"));

		if (projectId == null || !Utl.equals(oldProjectId, projectId)) {
			observer.onProjectChanged();
			return;
		} else if (!Utl.equals(oldPage, page) || !Utl.equals(oldEntityId, entityId)) {
			observer.onPageOrEntityChanged();
		} else {
			log.debug("Nothing changed");
		}
	}

	public static Map<String, String> parseHistoryToken(String token) {
		if (token == null || token.length() == 0) return Collections.emptyMap();
		Map<String, String> map = new HashMap<String, String>();
		char separator = '|';
		int idx = token.indexOf(separator);
		while (idx > 0) {
			String subtoken = token.substring(0, idx);
			parseHistorySubToken(subtoken, map);
			token = token.substring(idx + 1);
			idx = token.indexOf(separator);
		}
		parseHistorySubToken(token, map);
		return map;
	}

	private static void parseHistorySubToken(String token, Map<String, String> map) {
		int idx = token.indexOf('=');
		if (idx < 0) {
			map.put(token, token);
			return;
		}
		String key = token.substring(0, idx);
		String value = token.substring(idx + 1);
		map.put(key, value);
	}

	public void update(String projectId) {
		History.newItem(projectId == null ? "projectSelector" : "project=" + projectId, true);
	}

	public String getProjectId() {
		return projectId;
	}

	public boolean isProjectIdSet() {
		return projectId != null;
	}

	public String getPage() {
		return page;
	}

	public String getEntityId() {
		return entityId;
	}

	public boolean isToggle() {
		return toggle;
	}

	class TokenChangeHandler implements ValueChangeHandler<String> {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			evalHistoryToken(event.getValue());
		}

	}

}
