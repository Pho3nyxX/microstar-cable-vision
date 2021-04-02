import java.io.Serializable;

import models.chat._Message;
import models.users._Customer;

import utilities.ServerRequest;
import utilities.ServerResponse;

public class Customer extends _Customer implements Serializable{

    public void liveChat (_Message message) {
        //Login to live chat
        ServerRequest<_Message> request = new ServerRequest<_Message>(ServerRequest.USER_LIVE_CHAT_COMMAND, message);
        App.messageConnection.sendAction(request);
    }

    @Override
    public void LodgeComplaint() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
