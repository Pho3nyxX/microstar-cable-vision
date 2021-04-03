package controllers;

import models.users._Authethication;
import models.users._User;
import models.users.Customer;
import models.users.Employee;
import utilities.ServerRequest;
import utilities.ServerResponse;

import driver.*;

public class Authentication extends _Authethication {
    @Override
    public boolean login(String username, String password) {
        _User user = new Customer();
        boolean loggedIn = false;
        user.setUsername(username);
        user.setPassword(password);
        //cerate request object to send to server
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_LOGIN_COMMAND, user); 
        Driver.clientConnection.sendAction(request);
        // TODO: Check if user was logged in
        ServerResponse response = Driver.clientConnection.receiveResponse();
        if(response.getCode() == ServerResponse.REQUEST_SUCCEEDED){
            //request.setCommand(ServerRequest.USER_GET_LOGGED_IN_COMMAND);
            //App.clientConnection.sendAction(request);
            Driver.sessionId = response.getData().toString(); 
            loggedIn = true;
            System.out.println(response);
        }else{
            System.out.println(response);
            // System.err.println("Failed");
        }
        Driver.clientConnection.closeConnection();

        return loggedIn;
    }

    @Override
    public boolean logout(String sessionId) {
        // TODO Auto-generated method stub
        boolean loggedOut = false;
        // send logout request to server to update database        
        ServerRequest<String> request = new ServerRequest<String>(ServerRequest.USER_LOGOUT_COMMAND, sessionId); 
        Driver.clientConnection.sendAction(request);
        
        // Check if user was logged out successfully
        ServerResponse response = Driver.clientConnection.receiveResponse();
        if(response.getCode() == ServerResponse.REQUEST_SUCCEEDED){
            Driver.sessionId = null; 
            loggedOut = true;
        }
        Driver.clientConnection.closeConnection();

        return loggedOut;
    }
    
}
