import models.users._Customer;

import utilities.ServerRequest;

public class Customer extends _Customer {

    @Override
    public boolean login(String username, String password) {
        // TODO Auto-generated method stub
        this.username = username;
        this.password = password;
        ServerRequest<Customer> request = new ServerRequest<Customer>("Login-customer", this); 
        return false;
    }

    @Override
    public boolean logout(String arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean register() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void LodgeComplaint() {
        // TODO Auto-generated method stub
        
    }
    
}
