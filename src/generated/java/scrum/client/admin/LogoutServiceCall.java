// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class LogoutServiceCall extends scrum.client.core.AServiceCall {

    public  LogoutServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().logout(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "Logout";
    }

}

