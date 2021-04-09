package utilities.communication;

import driver.Driver;
import models.chat._Message;
import utilities.ServerRequest;
import utilities.ServerResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import models.users._User;
import models.users.Customer;
import models.users.Employee;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;

public class MultipleClientHandler implements Runnable {
    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");
    protected Socket connectionSocket;

    public MultipleClientHandler(Socket socketObject) {
        this.connectionSocket = socketObject;
    }

    @Override
    public void run() {
        try {
            ServerRequest action;
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());

            //this.configureStreams();
            //stmt = dBConn.createStatement();
            //result = s.executeQuery("SELECT * FROM user");
                   /* if(rs.next()){
                        System.out.println(rs.getString(2));
                    } */
            connection.warn("Attempting to receive data from client");
            action = (ServerRequest) objectInputStream.readObject();
            System.out.println("Log user in");
            connection.info("Data successfully received from client");
            //System.out.println(action.getClass());

            System.out.println(action);
            switch (action.getCommand()) {
                case ServerRequest.USER_LOGIN_COMMAND -> {
                    //Actions for user login
                    boolean loggedIn = false;
                    int code = ServerResponse.REQUEST_FAILED;
                    UUID sessionId = null;
                    String message = "Login Failed.";
                    ServerResponse response;
                    _User user = (_User)action.getData(); 
                    // System.out.println(user.get);
                    
                    //System.out.println(action.getData().toString());
                    //TODO: generate sessionId 
                    
                    // TODO: check database to match credentials, update database - user session 
                    
                    //send response to client
                    if(true){// TODO: test if user data is corrects
                        loggedIn = true;
                        sessionId = UUID.randomUUID();
                        code = ServerResponse.REQUEST_SUCCEEDED;
                        message = "Logged in successfully";
                    }
                    response = new ServerResponse<UUID>(message, code, sessionId);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.USER_LOAD_COMMAND -> {
                    int code = ServerResponse.REQUEST_FAILED;
                    String message = "User doesn't exist.";
                    ServerResponse response;
                    _User user = (_User)action.getData();

                    // TODO:: Handle user load
                    if (true) {//TODO: check if users found
                        message = "User found";
                        code = ServerResponse.REQUEST_SUCCEEDED;
                    }
                    response = new ServerResponse<_User>(message, code, user);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.USER_LOAD_MANY_COMMAND ->{
                    int code = ServerResponse.REQUEST_FAILED;
                    String message = "No users found.";
                    ServerResponse response;
                    ArrayList<_User> userList = new ArrayList();
                    // TODO: load users
                    if (true) {//TODO: check if users found
                        message = "Users found"; //TODO: add user count to message
                        code = ServerResponse.REQUEST_SUCCEEDED;
                        userList.add(new Customer());
                        userList.add(new Customer());
                    } else {
                        message = "No users found"; //TODO: add user count to message
                        code = ServerResponse.REQUEST_FAILED;                       
                    }
                    response = new ServerResponse<ArrayList<_User>>(message, code, userList);
                    objectOutputStream.writeObject(response);
                }

                case ServerRequest.USER_UPDATE_COMMAND -> {
                    int code = ServerResponse.REQUEST_FAILED;
                    String message = "No users found.";
                    ServerResponse response;
                    _User user = (_User)action.getData();

                    // TODO:: Handle user save
                    
                    response = new ServerResponse<_User>(message, code, user);
                    objectOutputStream.writeObject(response);
                }

                case "User-Register" -> {
                    //Actions to register user
                }

                case ServerRequest.USER_LIVE_CHAT_COMMAND -> {
                    //Actions to run live chat

                    //Check if user is a Customer or an Employee of type
                    _User user = (_User) action.getData();

                    //if Customer
                    if (user.getClass().getSimpleName().equals("Customer")) {
                        //Add customer to current list of online customers
                        LiveChat.customerArrayList.add((Customer) user);

                        ServerResponse response;
                        String message = "Login Successful";
                        int code = ServerResponse.REQUEST_SUCCEEDED;
                        response = new ServerResponse<ArrayList<Employee>>(message,code, LiveChat.employeeArrayList);
                        objectOutputStream.writeObject(response);

                    }else if (user.getClass().getSimpleName().equals("Employee")) {
                        //Check for the type of Employee, It should be a Technician
                        Employee employee = (Employee) user;

                        if (employee.getRole().equals("Technician")) {
                            //Add Technician to current list of online technicians
                            LiveChat.employeeArrayList.add(employee);

                            ServerResponse response;
                            String message = "Login Successful";
                            int code = ServerResponse.REQUEST_SUCCEEDED;
                            response = new ServerResponse<ArrayList<Customer>>(message,code,LiveChat.customerArrayList);
                            objectOutputStream.writeObject(response);
                        }else if (employee.getRole().equals("Customer Service Rep") || employee.getRole().equals("Admin")) {
                            //Don't allow them to log on to live chat
                            ServerResponse response;
                            String message = "Login Failed";
                            int code = ServerResponse.REQUEST_FAILED;
                            response = new ServerResponse<_User>(message,code,user);
                            objectOutputStream.writeObject(response);
                        }
                    }
                }
                case ServerRequest.USER_END_CHAT_COMMAND -> {
                    //Actions to log the user off the live chat

                    //Check if user is a Customer or an Employee of type
                    _User user = (_User) action.getData();

                    //if Customer
                    if (user.getClass().getSimpleName().equals("Customer")) {
                        //Remove customer from current list of online customers
                        LiveChat.customerArrayList.remove( (Customer) user);

                        ServerResponse response;
                        String message = "Log Out Successful";
                        int code = ServerResponse.REQUEST_SUCCEEDED;
                        response = new ServerResponse<ArrayList<Customer>>(message,code,LiveChat.customerArrayList);
                        objectOutputStream.writeObject(response);

                    }else if (user.getClass().getSimpleName().equals("Employee")) {

                        //Remove Technician from current list of online technicians
                        LiveChat.employeeArrayList.remove((Employee) user);

                        ServerResponse response;
                        String message = "Log Out Successful";
                        int code = ServerResponse.REQUEST_SUCCEEDED;
                        response = new ServerResponse<ArrayList<Employee>>(message,code, LiveChat.employeeArrayList);
                        objectOutputStream.writeObject(response);
                    }
                }
                case ServerRequest.USER_SEND_MESSAGE_LIVE_CHAT_COMMAND -> {
                    _Message message = (_Message) action.getData();
                    //Actions to send message
                    for (Employee employee: LiveChat.employeeArrayList) {
                        if (message.getRecipientId() == employee.getUserID() ) {
                            //Send message to that employee
                            ServerResponse response;
                            String responseMessage = "Incoming message";
                            int code = ServerResponse.REQUEST_SUCCEEDED;
                            response = new ServerResponse<_Message>(responseMessage,code,message);
                            objectOutputStream.writeObject(response);
                        }
                    }

                    for (Customer customer: LiveChat.customerArrayList) {
                        if (message.getRecipientId() == customer.getUserID() ) {
                            //Send message to that customer

                        }
                    }
                    //Save the message to the database
                }
            }
        }catch (IOException | ClassNotFoundException ex) {
            error.error(ex.getMessage());
        }
    }


}
