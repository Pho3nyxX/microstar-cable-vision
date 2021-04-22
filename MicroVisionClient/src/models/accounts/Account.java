package models.accounts;

import java.util.List;

import driver.Driver;
import models.users.Customer;
import utilities.ServerRequest;
import utilities.ServerResponse;
import utilities.Validator;

public class Account extends _Account{
     /**
     *
     */
    private static final long serialVersionUID = -1553523207317986640L;

    Customer customer;

    int customerId;

    List<Service> services;

    List<Payment> payments;

    /**
     * save an account
     * @return
     */
    public boolean save() {
        
        boolean accountCreated = false;


        // validate data 
        if( this.validate()){

            // Create request with user data
            ServerRequest<Account> request = new ServerRequest<Account>(ServerRequest.ACCOUNT_UPDATE_COMMAND, this); 

            Driver.clientConnection.createConnection();

            Driver.clientConnection.configureStreams();

            Driver.clientConnection.sendRequest(request);

            //App.clientConnection.closeConnection();
            ServerResponse response = Driver.clientConnection.receiveResponse();

            if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {

                accountCreated = true;

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
        return accountCreated;
    }


    public void refresh() throws Exception{ //TODO update with custom exceptions

        //TODO: refresh userdata from server

        ServerRequest<Account> request = new ServerRequest<Account>(ServerRequest.ACCOUNT_LOAD_COMMAND, this); 

        Driver.clientConnection.createConnection();

        Driver.clientConnection.configureStreams();

        Driver.clientConnection.sendRequest(request);
        //App.clientConnection.closeConnection();

        ServerResponse<Account> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {

            this.accountID = ( (Account)response.getData() ).accountID;

            this.amountDue = ( (Account)response.getData() ).amountDue;

            this.accountStatus = ( (Account)response.getData() ).accountStatus;

            //TODO handle user creation succeed

        } else{

            //TODO handle user creation failed

            throw new Exception("Unable to refresh account");

        }

        Driver.clientConnection.closeConnection();

    }

    @Override
    public boolean validate() {

        //TODO implement individual validators
        boolean valid = super.validate();

        return valid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
