// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.project;

public class DeleteStoryServiceCall extends scrum.client.core.AServiceCall {

    private String storyId;

    public  DeleteStoryServiceCall(String storyId) {
        this.storyId = storyId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().deleteStory(conversationNumber, storyId, callback);
    }

    @Override
    public String toString() {
        return "DeleteStory";
    }

}

