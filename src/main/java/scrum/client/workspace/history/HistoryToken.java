package scrum.client.workspace.history;

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
	private String page = "Dashboard";
	private String entityId;

	public HistoryToken(HistoryTokenObserver observer) {
		this.observer = observer;
		History.addValueChangeHandler(new TokenChangeHandler());
	}

	private void evalHistoryToken(String token) {
		log.debug("Evaluating history token:", token);
		Map<String, String> props = parseHistoryToken(token);

		String pProjectId = props.get("project");
		String pPage = props.get("page");
		String pEntityId = props.get("entity");

		if (!Utl.equals(pProjectId, projectId)) {
			observer.onProjectChanged();
		} else if (!Utl.equals(pPage, page)) {
			observer.onPageChanged();
		} else if (!Utl.equals(pEntityId, entityId)) {
			observer.onEntityChanged();
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

	class TokenChangeHandler implements ValueChangeHandler<String> {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			evalHistoryToken(event.getValue());
		}

	}

}
