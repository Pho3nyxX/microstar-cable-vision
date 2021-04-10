package models.accounts;

import java.time.LocalDate;

import driver.Driver;
import utilities.ServerRequest;
import utilities.ServerResponse;
import utilities.Validator;

public class Service extends _Service{
     /**
     *
     */
    private static final long serialVersionUID = -5707531268648422965L;

        // @Override
    public boolean save() {
        boolean serviceCreated = false; 

        // validate data 
        if( this.validate()){
            // Create request with user data
            ServerRequest<Service> request = new ServerRequest<Service>(ServerRequest.SERVICE_UPDATE_COMMAND, this); 
            Driver.clientConnection.createConnection();
            Driver.clientConnection.configureStreams();
            Driver.clientConnection.sendAction(request);
            //App.clientConnection.closeConnection();
            ServerResponse response = Driver.clientConnection.receiveResponse();
            if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
                serviceCreated = true;
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
        return serviceCreated;
    }
        
    @Override
    public boolean validate() {
        //TODO implement individual validators
        boolean valid = super.validate();

        return valid;
    }

    public Service(int serviceID, String typeOfService, LocalDate dateInitiated, String status, int accountID) {
        super(serviceID, typeOfService, dateInitiated, status, accountID);
    }

    public Service() {
        super();
    }
}
