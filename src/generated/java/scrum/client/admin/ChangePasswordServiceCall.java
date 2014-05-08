// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class ChangePasswordServiceCall extends scrum.client.core.AServiceCall {

    private String newPassword;

    private String oldPassword;

    public  ChangePasswordServiceCall(String newPassword, String oldPassword) {
        this.newPassword = newPassword;
        this.oldPassword = oldPassword;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().changePassword(conversationNumber, newPassword, oldPassword, callback);
    }

    @Override
    public String toString() {
        return "ChangePassword";
    }

}

