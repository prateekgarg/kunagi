// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class ResetPasswordServiceCall extends scrum.client.core.AServiceCall {

    private String userId;

    public  ResetPasswordServiceCall(String userId) {
        this.userId = userId;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().resetPassword(conversationNumber, userId, callback);
    }

    @Override
    public String toString() {
        return "ResetPassword";
    }

}

