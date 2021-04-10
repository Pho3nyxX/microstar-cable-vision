package controllers;

import models.chat._Message;
import sound.Mp3;
import driver.Driver;
import javazoom.jl.decoder.JavaLayerException;
import models.users._User;
import utilities.ServerRequest;
import utilities.ServerResponse;

public class LiveChat {

    public void logOnToLiveChat (_User user) {
        //Login to live chat
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_LIVE_CHAT_COMMAND, user);
        Driver.messageConnection.sendAction(request);

        ServerResponse response;
        response = Driver.messageConnection.receiveResponse();

        if (response.getMessage().equals("Login Successful")) {


            if (user.getClass().getSimpleName().equals("Customer")) {
                //Send a message to all Customers the technicians that are online
                //play an mp3 sound - maybe a ping
                    System.out.println("Technician " + user.getfirstName() + " is online");
                    try {
                        Mp3.playMp3("1");
                    }catch (JavaLayerException ex) {
                        System.out.println("Error message to be logged");
                    }
            }else if (user.getClass().getSimpleName().equals("Employee")) {
                    //Send a message to all Technicians the customers that are online
                    //play an mp3 sound - maybe a ping
                    /*for (Customer customer: customerArrayList) {
                        System.out.println("Customer " + customer.getfirstName() + " is online");
                        try {
                            Mp3.playMp3("1");
                        }catch (JavaLayerException ex) {
                            System.out.println("Error message to be logged");
                        }
                    } */
                }
        }else if (response.getMessage().equals("Login Failed")) {
            System.out.println("Failed to Login");
        }
    }

    public void logOffLiveChat(_User user) {
        //Log off live chat
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_END_CHAT_COMMAND, user);
        Driver.messageConnection.sendAction(request);

        ServerResponse response;
        response = Driver.messageConnection.receiveResponse();

        //Inform all Employees and Customers who are online who has logged off
        if (response.getMessage().equals("Log Out Successful")) {
            //If it was a customer who wanted to log off, notify the Technicians that the customer is offline
         /*   if (user.getClass().getSimpleName().equals("Customer")) {
                for (Customer customer : customerArrayList) {
                    System.out.println("Customer " + customer.getfirstName() + " is offline");
                }
            } else if (user.getClass().getSimpleName().equals("Employee")) {
                //If it was an Employee who wanted to log off, notify the Customers that the technician is offline
                for (Employee employee : employeeArrayList) {
                    System.out.println("Technician " + employee.getfirstName() + " is offline");
                }
            } */

            //Close the message connection socket for the user who wishes to log off
            Driver.messageConnection.closeConnection();
        }
    }

    public static void sendMessage(_Message message) {
        //Send messages through live chat
        ServerRequest<_Message> request = new ServerRequest<_Message>(ServerRequest.USER_SEND_MESSAGE_LIVE_CHAT_COMMAND,
                message);
        Driver.messageConnection.sendAction(request);
    }

    public static void receiveMessage() {
            ServerResponse response;
            response = Driver.messageConnection.receiveResponse();

            //Would output the message to the GUI
    }
}
