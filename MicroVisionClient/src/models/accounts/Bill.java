package models.accounts;

import java.util.ArrayList;

import models.accounts._Bill;
import models.accounts.Bill;
import models.accounts.*;
import models.chat._Message;

import driver.Driver;
import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class Bill extends _Bill {

    private static final long serialVersionUID = 8129064095859270050L;


    @Override
    public boolean save() {
        boolean userCreated = false;

        // validate data
        if( this.validate()){
            // Create request with user data
            ServerRequest<Bill> request = new ServerRequest<Bill>(ServerRequest.USER_UPDATE_COMMAND, this);
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
        ServerRequest<Bill> request = new ServerRequest<Bill>(ServerRequest.USER_LOAD_COMMAND, this);
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Bill> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.billID = ((Bill)response.getData()).getBillID();
            this.date = ((Bill)response.getData()).getDate();
            this.periodStart = ((Bill)response.getData()).getPeriodStart();
            this.periodEnd = ((Bill)response.getData()).getPeriodEnd();
            this.amount = ((Bill)response.getData()).getAmount();
            this.due = ((Bill)response.getData()).getDue();
            this.serviceID = ((Bill)response.getData()).getServiceID();


            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        Driver.clientConnection.closeConnection();
    }
    
}
