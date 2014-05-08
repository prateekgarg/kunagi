// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class PullStoryToSprintServiceCall extends scrum.client.core.AServiceCall {

    private String storyId;

    public  PullStoryToSprintServiceCall(String storyId) {
        this.storyId = storyId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().pullStoryToSprint(conversationNumber, storyId, callback);
    }

    @Override
    public String toString() {
        return "PullStoryToSprint";
    }

}

