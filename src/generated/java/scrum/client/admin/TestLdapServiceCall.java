// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.admin;

public class TestLdapServiceCall extends scrum.client.core.AServiceCall {

    public  TestLdapServiceCall() {
    }

    public void execute(Runnable returnHandler) {
        serviceCaller.onServiceCall();
        serviceCaller.getService().testLdap(serviceCaller.getConversationNumber(), new DefaultCallback(returnHandler));
    }

    @Override
    public String toString() {
        return "TestLdap";
    }

}

