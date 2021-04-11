package models.accounts;

import java.util.ArrayList;

import models.accounts.Payment;
import models.accounts._Payment;
import models.chat._Message;

import driver.Driver;
import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class Payment extends _Payment {

    private static final long serialVersionUID =  -8844351185740139751L;

    @Override
    public boolean save() {
        boolean userCreated = false;

        // validate data
        if( this.validate()){
            // Create request with user data
            ServerRequest<Payment> request = new ServerRequest<Payment>(ServerRequest.USER_UPDATE_COMMAND, this);
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
        ServerRequest<Payment> request = new ServerRequest<Payment>(ServerRequest.USER_LOAD_COMMAND, this);
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Payment> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.paymentID = ((Payment)response.getData()).getPaymentID();
            this.paymentStatus = ((Payment)response.getData()).getPaymentStatus();
            this.paymentDueDate = ((Payment)response.getData()).getPaymentDueDate();
            this.accountID = ((Payment)response.getData()).getAccountID();

            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        Driver.clientConnection.closeConnection();
    }

}
