import java.io.Serializable;

import models.users._Customer;

import utilities.ServerRequest;

public class Customer extends _Customer implements Serializable{

    //@Override
    public boolean login(String username, String password) {
        // TODO Auto-generated method stub
        boolean loggedIn = false; 
        this.username = username;
        this.password = password;
        //cerate request object to send to server
        ServerRequest<Customer> request = new ServerRequest<Customer>("Login-customer", this); 
        App.clientConnection.sendAction(request);
        App.clientConnection.closeConnection();

        return loggedIn;
    }

    //@Override
    public boolean logout(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    //@Override
    public boolean register() {
        // TODO Auto-generated method stub
        return false;
    }

    //@Override
    public void LodgeComplaint() {
        // TODO Auto-generated method stub
        
    }
    
}
