// // ----------> GENERATED FILE - DON'T TOUCH! <----------

package scrum.client.search;

public class SearchServiceCall extends scrum.client.core.AServiceCall {

    private String text;

    public  SearchServiceCall(String text) {
        this.text = text;
    }

    @Override
    public void onExecute(int conversationNumber, com.google.gwt.user.client.rpc.AsyncCallback<scrum.client.DataTransferObject> callback) {
        getService().search(conversationNumber, text, callback);
    }

    @Override
    public String toString() {
        return "Search";
    }

}

