package models.users;

import models.users.*;
import utilities.*;
import models.chat._Message;

import java.util.ArrayList;

import driver.Driver;

public class Employee extends _Employee{

        
    /**
     *
     */
    private static final long serialVersionUID = -7407503122655621232L;



    // @Override
    public boolean save() {
        boolean userCreated = false; 
        // Create request with user data
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_UPDATE_COMMAND, this); 
        
        Driver.clientConnection.createConnection();

        Driver.clientConnection.configureStreams();

        Driver.clientConnection.sendAction(request);

        ServerResponse response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.SAVE_SUCCEEDED) {
            userCreated = true;
            System.out.println(response);
            
        } else{
            //TODO handle user creation failed 
            //Add error returned from server to validation errors array
            this.validation_errors.add(response.getMessage());
        }

        Driver.clientConnection.closeConnection();

        return userCreated;
    }

    public void refresh() throws Exception{ //TODO update with custom exceptions
        //TODO: refresh userdata from server
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_LOAD_COMMAND, this); 
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<Employee> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            this.userID = ((Employee)response.getData()).getUserID();
            this.age = ((Employee)response.getData()).getAge();
            this.role = ((Employee)response.getData()).getRole();
            this.isOnline = ((Employee)response.getData()).isOnline;
            this.username = ((Employee)response.getData()).getUsername();
            this.firstName = ((Employee)response.getData()).getfirstName();
            this.lastName = ((Employee)response.getData()).getlastName();
            this.middleName = ((Employee)response.getData()).getmiddleName();
            
            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed
            throw new Exception("Unable to refresh user");
        }
        Driver.clientConnection.closeConnection();
    }

    public static ArrayList<Employee> loadCustomers(){
        // load customers from datatbase
        ArrayList<Employee> employees = null;
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_LOAD_MANY_COMMAND, new Employee()); 
        Driver.clientConnection.createConnection();
        Driver.clientConnection.configureStreams();
        Driver.clientConnection.sendAction(request);
        //App.clientConnection.closeConnection();
        ServerResponse<ArrayList<Employee>> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.REQUEST_SUCCEEDED) {
            employees = response.getData();
            System.out.println(employees);
            //TODO handle user creation succeed
        } else{
            //TODO handle user creation failed 
            
        }
        Driver.clientConnection.closeConnection();

        return employees;
    }

    // @Override
    public boolean delete() {
        // TODO Auto-generated method stub
        boolean userDeleted = false;
        ServerRequest<Employee> request = new ServerRequest<Employee>(ServerRequest.USER_DELETE_COMMAND , this); 
        Driver.clientConnection.sendAction(request);
        ServerResponse<Integer> response = Driver.clientConnection.receiveResponse();
        if (response.getCode() == ServerResponse.DELETE_SUCCEEDED) {
            userDeleted = true;
            //TODO handle user creation succeed
        }else{
            this.validation_errors.add("User delete failed.");
        }
        return userDeleted;
    }

    public Employee() {
    }

    public Employee(int userID, String username, String firstName, String lastName, String middleName, String password,
            int age, String gender, String role, String status) {
        super(userID, username, firstName, lastName, middleName, password, age, gender, role, status);
    }

}
