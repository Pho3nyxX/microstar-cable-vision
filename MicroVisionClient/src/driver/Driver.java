package driver; 
import utilities.*;

import controllers.Authentication;
import java.util.ArrayList;

import javax.swing.JFrame;

import models.users.*;
import utilities.communication.*;
import views.customer.SignIn;

public class Driver extends JFrame{
    public static Client clientConnection; //socket connection for general purpose use in the app
    public static Client messageConnection; //socket connection for use with chat
    public static _User user; // the currently logged in user
    public static String sessionId; //identifies a session based on user-id and a random string 
    public static String APP_NAME = "MicroStar Cable Vision";


    
    public Driver() {
        super(Driver.APP_NAME);
        clientConnection = new Client();
    }
    
    public Driver(String title) {
        super(title);
        clientConnection = new Client();
    }


    
    public static void main(String[] args) throws Exception {
        
        Driver driver = new Driver();

        SignIn signInDialog = new SignIn(driver);

        // signInDialog.setVisible(true);


        // set window properties
        driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close app when window is closed
        driver.setSize(500, 500); // set panel window size
        driver.setLayout(null);
        driver.setVisible(true);


/*
        System.out.println("Hello, World!");
        Authentication auth =  new Authentication();
        auth.login("Abi", "Gordon"); 
        ArrayList<Customer> customers = Customer.loadCustomers();

        Customer customer = new Customer();
        customer.save();
        */
    }
}
