package models.accounts;
import java.util.ArrayList;

import models.accounts._Service;
import models.accounts.Service;
import models.accounts.*;
import models.chat._Message;

import driver.Driver;
import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class Service extends _Service{

    private static final long serialVersionUID = -6525110385549761655L;

    @Override
    public boolean save() {
        boolean userCreated = false;

        // validate data
        if( this.validate()){
            // Create request with user data
            ServerRequest<Service> request = new ServerRequest<Service>(ServerRequest.USER_UPDATE_COMMAND, this);
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
        ServerRequest<Service> request = new ServerRequest<Service>(ServerRequest.USER_LOAD_COMMAND, this);
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Service> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.serviceID = ((Service)response.getData()).getServiceID();
            this.typeOfService = ((Service)response.getData()).getTypeOfService();
            this.dateInitiated = ((Service)response.getData()).getDateInitiated();
            this.status = ((Service)response.getData()).getStatus();
            this.accountID = ((Service)response.getData()).getAccountID();



            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        Driver.clientConnection.closeConnection();
    }

    
}
