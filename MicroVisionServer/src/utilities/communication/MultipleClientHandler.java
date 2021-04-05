package utilities.communication;

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
import java.util.List;
import java.util.UUID;

public class MultipleClientHandler implements Runnable {
    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");
    protected Socket connectionSocket;
    protected UUID sessionId = null; //TODO:: remove this is a client side data
    protected ServerResponse response; //TODO:: remove these will spawn randomly based on the client-server communication 
    protected int code; //TODO:: remove these will spawn randomly based on the client-server communication 

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
                    //Actions for user logout
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

                    //sessionId = UUID.randomUUID(); //TODO:: remove not necessary here

                    //Actions to run live chat
                    while (!ServerRequest.USER_END_CHAT_COMMAND) {
                        List<MultipleClientHandler> clientHandlerList = Server.getClientHandlerList();
                        for (MultipleClientHandler client: clientHandlerList) {
                            //response = new ServerResponse<UUID>(action.getData())
                        }
                    }
                }
            }
        }catch (IOException | ClassNotFoundException ex) {
            error.error(ex.getMessage());
        }
    }


}
