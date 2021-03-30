import utilities.ServerRequest;
import utilities.ServerResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
            switch (action.getCommand()) {
                case ServerRequest.USER_LOGIN_COMMAND -> {
                    //Actions for user login
                    boolean loggedIn = false;
                    int code = ServerResponse.REQUEST_FAILED;
                    UUID sessionId = null;
                    ServerResponse response;
                    //System.out.println(action.getData().toString());
                    //TODO: generate sessionId 
                    
                    // TODO: check database to match credentials, update database - user session 
                    
                    //send response to client
                    if(true){// TODO: test if user data is corrects
                        loggedIn = true;
                        sessionId = UUID.randomUUID();
                        code = ServerResponse.REQUEST_SUCCEEDED;
                    }
                    response = new ServerResponse<UUID>("Logged in successfully", ServerResponse.REQUEST_SUCCEEDED, sessionId);
                    objectOutputStream.writeObject(response);
                }
                case "User-Logout" -> {
                    //Actions for user logout
                }
                case "User-Register" -> {
                    //Actions to register user
                }
            }
        }catch (IOException | ClassNotFoundException ex) {
            error.error(ex.getMessage());
        }
    }
}
