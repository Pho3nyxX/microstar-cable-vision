package models.users;

import java.util.ArrayList;
import java.util.List;

import models.users._Customer;
import models.users.Address;
import models.accounts.Account;
import models.chat._Message;

import utilities.ServerRequest;
import utilities.ServerResponse;
import utilities.Validator;

import driver.*;

public class Customer extends _Customer{
    
    private static final long serialVersionUID = -7122240510909524901L;

    protected ContactNumber phone;
    protected List<Account> accounts;
    protected List<Address> addresses;

    // @Override
    public void LodgeComplaint() {

        // TODO Auto-generated method stub
        
    }


    // @Override
    public boolean save() {

        boolean userCreated = false; 

        // validate data 
        if( this.validate()){

            // Create request with user data
            ServerRequest<Customer> request = new ServerRequest<Customer>(ServerRequest.USER_UPDATE_COMMAND, this); 

            Driver.clientConnection.createConnection();

            Driver.clientConnection.configureStreams();

            Driver.clientConnection.sendRequest(request);

            ServerResponse response = Driver.clientConnection.receiveResponse();

            if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {

                userCreated = true;

                System.out.println(response);

            } else{

                //Add error returned from server to validation errors array
                System.out.println(response);

                this.validation_errors.add(response.getMessage());
            }

            Driver.clientConnection.closeConnection();
        }

        return userCreated;
    }
    

    @Override
    public boolean validate() {

        //TODO implement individual validators
        boolean valid = super.validate();

        // check if each fields data is valid
        if( !( Validator.validate(this.email, Validator.EMAIL) ) ){

            this.validation_errors.add("Invalid email entered.");
            valid = false;
        }
        
        return valid;
    }


    public void refresh() throws Exception{ //TODO update with custom exceptions

        //TODO: refresh userdata from server
        ServerRequest<Customer> request = new ServerRequest<Customer>(ServerRequest.USER_LOAD_COMMAND, this);

        Driver.clientConnection.createConnection();

        Driver.clientConnection.configureStreams();

        Driver.clientConnection.sendRequest(request);

        //App.clientConnection.closeConnection();
        ServerResponse<Customer> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {

            this.userID = ((Customer)response.getData()).getUserID();

            this.age = ((Customer)response.getData()).getAge();

            this.email = ((Customer)response.getData()).getEmail();

            this.isOnline = ((Customer)response.getData()).isOnline;

            this.phone = ((Customer)response.getData()).phone;

            this.addresses = ((Customer)response.getData()).addresses;

            this.accounts = ((Customer)response.getData()).accounts;

            this.username = ((Customer)response.getData()).getUsername();

            this.firstName = ((Customer)response.getData()).getfirstName();

            this.lastName = ((Customer)response.getData()).getlastName();

            this.middleName = ((Customer)response.getData()).getmiddleName();
            
            //TODO handle user creation succeed

        } else{

            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }

        Driver.clientConnection.closeConnection();
    }
    

    public static ArrayList<Customer> loadCustomers(){

        // load customers from datatbase
        ArrayList<Customer> customers = null;

        ServerRequest<Customer> request = new ServerRequest<Customer>(ServerRequest.USER_LOAD_MANY_COMMAND, new Customer()); 

        Driver.clientConnection.createConnection();
        
        Driver.clientConnection.configureStreams();

        Driver.clientConnection.sendRequest(request);

        //App.clientConnection.closeConnection();
        ServerResponse<ArrayList<Customer>> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {

            customers = response.getData();

            System.out.println(customers);

            //TODO handle user creation succeed

        } else{
            //TODO handle user creation failed 
            
        }
        Driver.clientConnection.closeConnection();

        return customers;
    }


    // @Override
    public boolean delete() {

        // TODO Auto-generated method stub
        boolean userDeleted = false;

        ServerRequest<Customer> request = new ServerRequest<Customer>(ServerRequest.USER_REGISTER_COMMAND, this); 

        Driver.clientConnection.createConnection();

        Driver.clientConnection.configureStreams();

        Driver.clientConnection.sendRequest(request);

        ServerResponse<Integer> response = Driver.clientConnection.receiveResponse();

        if (response.getCode() == ServerResponse.DELETE_SUCCEEDED) {

            userDeleted = true;

            //TODO handle user creation succeed

        }else{

            this.validation_errors.add("User delete failed.");
        }

        return userDeleted;
    }


    /**--------------------------------------------------------------------------------------- */
    public Customer(){

    }

    public Customer(int userID, String username, String firstName, String lastName, String middleName, String password, int age,
    String gender, String email, _Address address){
        
        super(userID, username, firstName, lastName, middleName, password, age, gender, email, address);
    }
}
