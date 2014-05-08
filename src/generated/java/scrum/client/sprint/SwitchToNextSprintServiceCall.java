// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.sprint;

public class SwitchToNextSprintServiceCall extends scrum.client.core.AServiceCall {

    public  SwitchToNextSprintServiceCall() {
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().switchToNextSprint(conversationNumber, callback);
    }

    @Override
    public String toString() {
        return "SwitchToNextSprint";
    }

}

