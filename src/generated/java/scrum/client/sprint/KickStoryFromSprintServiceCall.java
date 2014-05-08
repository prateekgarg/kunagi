// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class KickStoryFromSprintServiceCall extends scrum.client.core.AServiceCall {

    private String storyId;

    public  KickStoryFromSprintServiceCall(String storyId) {
        this.storyId = storyId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().kickStoryFromSprint(conversationNumber, storyId, callback);
    }

    @Override
    public String toString() {
        return "KickStoryFromSprint";
    }

}

