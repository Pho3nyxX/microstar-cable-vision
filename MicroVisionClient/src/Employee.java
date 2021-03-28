import java.io.Serializable;

import models.users.*;
import utilities.*;

public class Employee extends _Employee implements Serializable{

    @Override
    public boolean registerUser(_User user) {
        boolean userCreated = false; 
        // TODO Auto-generated method stub
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_REGISTER_COMMAND, user); 
        App.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse response = App.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.USER_SAVED_SUCCESSFUL_RESPONSE) {
            userCreated = true; 
            
            //TODO handle user creation succeed
        } else {
            //TODO handle user creation failed 
            
        }
        App.clientConnection.closeConnection();
        return userCreated;
    }
    
}
