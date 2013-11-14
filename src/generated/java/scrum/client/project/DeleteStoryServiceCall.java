// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class DeleteStoryServiceCall extends scrum.client.core.AServiceCall {

	private String storyId;

	public DeleteStoryServiceCall(String storyId) {
		this.storyId = storyId;
	}

	@Override
	public void execute(Runnable returnHandler) {
		serviceCaller.onServiceCall(this);
	}

	@Override
	public String toString() {
		return "DeleteStory";
	}

}
