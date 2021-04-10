package models.accounts;

import java.time.LocalDate;

import driver.Driver;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class Payment extends _Payment {

    /**
     *
     */
    private static final long serialVersionUID = 6685701012871465008L;

       
    // @Override
    public boolean save() {
        boolean paymentCreated = false; 

        // validate data 
        if( this.validate()){
            // Create request with user data
            ServerRequest<Payment> request = new ServerRequest<Payment>(ServerRequest.PAYMENT_UPDATE_COMMAND, this); 
            Driver.clientConnection.createConnection();
            Driver.clientConnection.configureStreams();
            Driver.clientConnection.sendAction(request);
            //App.clientConnection.closeConnection();
            ServerResponse response = Driver.clientConnection.receiveResponse();
            if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
                paymentCreated = true;
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
        return paymentCreated;
    }
        
    @Override
    public boolean validate() {
        //TODO implement individual validators
        boolean valid = super.validate();

        return valid;
    }

    public Payment(int paymentID, double amount, String paymentStatus, LocalDate paymentDueDate, int accountID) {
        super(paymentID, amount, paymentStatus, paymentDueDate, accountID);
    }

    public Payment() {
        super();
    }
}
