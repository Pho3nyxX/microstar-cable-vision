package models.accounts;

import java.util.ArrayList;
import models.accounts._Account;
import models.accounts.*;

import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;
import utilities.Validator;

import driver.*;

//Save and Refresh function

public class Account extends _Account{

    private static final long serialVersionUID = 8513410526093736170L;

    @Override
    public boolean save() {
        boolean userCreated = false;

        // validate data
        if( this.validate()){
            // Create request with user data
            ServerRequest<Account> request = new ServerRequest<Account>(ServerRequest.USER_UPDATE_COMMAND, this);
            Driver.clientConnection.createConnection();
            Driver.clientConnection.configureStreams();
            Driver.clientConnection.sendAction(request);
            //App.clientConnection.closeConnection();
            ServerResponse response = Driver.clientConnection.receiveResponse();
            if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
                userCreated = true;
                System.out.println(response);
                //TODO handle user creation succeed
            } else{
                //TODO handle user creation failed
                //Add error returned from server to validation errors array
                System.out.println(response);
                this.validation_errors.add(response.getMessage());
            }
            Driver.clientConnection.closeConnection();
        }
        return userCreated;
    }

    public void refresh() throws Exception{ //TODO update with custom exceptions
        //TODO: refresh userdata from server
        ServerRequest<Account> request = new ServerRequest<Account>(ServerRequest.USER_LOAD_COMMAND, this);
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Account> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.userID = ((Account)response.getData()).getUserID();
            this.age = ((Account)response.getData()).getAge();
            this.email = ((Account)response.getData()).getEmail();
            this.phone = ((Account)response.getData()).getPhone();
            this.username = ((Account)response.getData()).getUsername();
            this.firstName = ((Account)response.getData()).getfirstName();
            this.lastName = ((Account)response.getData()).getlastName();
            this.middleName = ((Account)response.getData()).getmiddleName();

            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        Driver.clientConnection.closeConnection();
    }



    
}
