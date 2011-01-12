package scrum.client.common;

import java.util.List;

public interface ThemesContainer {

	List<String> getThemes();

	List<String> getAvailableThemes();

	void setThemes(List<String> editorSelectedItems);

	boolean isThemesEditable();

}
