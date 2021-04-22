package models.accounts;

import java.time.LocalDate;

import driver.Driver;
import utilities.ServerRequest;
import utilities.ServerResponse;
import utilities.Validator;

public class Bill extends _Bill {

    /**
     *
     */
    private static final long serialVersionUID = 3075504526132439913L;

    
        // @Override
        public boolean save() {

            boolean billCreated = false; 
    
            // validate data 
            if( this.validate() ){

                // Create request with user data
                ServerRequest<Bill> request = new ServerRequest<Bill>(ServerRequest.BILL_UPDATE_COMMAND, this); 
                
                Driver.clientConnection.createConnection();
                
                Driver.clientConnection.configureStreams();
                
                Driver.clientConnection.sendRequest(request);
                //App.clientConnection.closeConnection();
                
                ServerResponse response = Driver.clientConnection.receiveResponse();
                
                if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
                
                    billCreated = true;
                
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
            
            return billCreated;

        }
            
        @Override
        public boolean validate() {

            //TODO implement individual validators
            boolean valid = super.validate();
    
            return valid;
        }

    public Bill(int billID, LocalDate date, LocalDate periodStart, LocalDate periodEnd, double amount, LocalDate due,
            int serviceID) {

        super(billID, date, periodStart, periodEnd, amount, due, serviceID);
    }

    public Bill() {
        super();
    }
    
}
