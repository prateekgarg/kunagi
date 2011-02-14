package scrum.client.workspace.history;

public interface HistoryTokenObserver {

	void onProjectChanged();

	void onPageOrEntityChanged();

}
