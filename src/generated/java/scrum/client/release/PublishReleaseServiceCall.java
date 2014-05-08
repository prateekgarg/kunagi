// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.release;

public class PublishReleaseServiceCall extends scrum.client.core.AServiceCall {

    private String releaseId;

    public  PublishReleaseServiceCall(String releaseId) {
        this.releaseId = releaseId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().publishRelease(conversationNumber, releaseId, callback);
    }

    @Override
    public String toString() {
        return "PublishRelease";
    }

}

