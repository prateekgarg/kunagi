// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.collaboration;

public class RequestForumServiceCall extends scrum.client.core.AServiceCall {

    private boolean all;

    public  RequestForumServiceCall(boolean all) {
        this.all = all;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().requestForum(conversationNumber, all, callback);
    }

    @Override
    public String toString() {
        return "RequestForum";
    }

}

