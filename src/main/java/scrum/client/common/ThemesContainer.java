package scrum.client.common;

import java.util.List;
import java.util.Set;

public interface ThemesContainer {

	List<String> getThemes();

	Set<String> getAvailableThemes();

	void setThemes(List<String> editorSelectedItems);

	boolean isThemesEditable();

}
