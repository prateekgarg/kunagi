// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class TestLdapServiceCall extends scrum.client.core.AServiceCall {

    public  TestLdapServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().testLdap(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "TestLdap";
    }

}

