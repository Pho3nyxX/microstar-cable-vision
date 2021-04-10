package controllers;

import models.chat._Message;
import models.users.Customer;
import models.users.Employee;
import sound.Mp3;
import driver.Driver;
import javazoom.jl.decoder.JavaLayerException;
import models.users._User;
import utilities.ServerRequest;
import utilities.ServerResponse;
import views.livechat.ChatHome;

import java.util.ArrayList;

public class LiveChat {

    public static void logOnToLiveChat (_User user) {
        //Login to live chat
        ServerRequest<_User> request = new ServerRequest<_User>(ServerRequest.USER_LIVE_CHAT_COMMAND, user);
        Driver.messageConnection.sendAction(request);

        ArrayList<_User> onlineUsersFromServer = null;

        ServerResponse<ArrayList<_User>> response = Driver.messageConnection.receiveResponse();
        onlineUsersFromServer = response.getData();

        if (response.getMessage().equals("Login Successful")) {
            if (user.getClass().getSimpleName().equals("Customer")) {
                //Send a message to all Customers the technicians that are online
                //play an mp3 sound - maybe a ping

                for (_User onlineUser:onlineUsersFromServer) {
                    if (onlineUser.getClass().getSimpleName().equals("Employee")) {
                        ChatHome.personsOnlineTextArea.append("Technician " + onlineUser.getUsername() + " is online \n");
                    }
                }
                try {
                    Mp3.playMp3("1");
                }catch (JavaLayerException ex) {
                    System.out.println("Error message to be logged");
                }
            }else if (user.getClass().getSimpleName().equals("Employee")) {
                //Send a message to all Technicians the customers that are online
                //play an mp3 sound - maybe a ping
                for (_User onlineUser:onlineUsersFromServer) {
                    if (onlineUser.getClass().getSimpleName().equals("Customer")) {
                        ChatHome.personsOnlineTextArea.append("Customer " + onlineUser.getUsername() + " is online \n");
                    }
                }
                try {
                    Mp3.playMp3("1");
                }catch (JavaLayerException ex) {
                    System.out.println("Error message to be logged");
                }
            }
        }else if (response.getMessage().equals("Login Failed")) {
            ChatHome.personsOnlineTextArea.setText("Failure to Log on to Live Chat");
        }
    }

    public static void logOffLiveChat(_User user) {
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

    public static _User findUserFromUsername(String username) {
        _User user = null;
        //Send a request to the server asking who's username is this and respond with the user
        if (Driver.SESSION_TYPE.equals("Customer")) {
            Employee employee = new Employee();
            employee.setUsername(username);
            ServerRequest request = new ServerRequest(ServerRequest.USER_LOAD_COMMAND,employee);
            Driver.messageConnection.sendAction(request);

            ServerResponse response = Driver.messageConnection.receiveResponse();
            user = (_User) response.getData();
        }else if (Driver.SESSION_TYPE.equals("Employee")) {
            Customer customer = new Customer();
            customer.setUsername(username);
            ServerRequest request = new ServerRequest(ServerRequest.USER_LOAD_COMMAND, customer);
            Driver.messageConnection.sendAction(request);

            ServerResponse response = Driver.messageConnection.receiveResponse();
            user = (_User) response.getData();
        }

        return user;
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
