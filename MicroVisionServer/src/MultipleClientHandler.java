import utilities.ServerRequest;
import utilities.ServerResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.UUID;

public class MultipleClientHandler implements Runnable {
    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");
    protected Socket connectionSocket;
    protected UUID sessionId = null;
    protected ServerResponse response;
    protected int code;

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
                    code = ServerResponse.REQUEST_FAILED;

                    //System.out.println(action.getData().toString());
                    //TODO: generate sessionId 
                    
                    // TODO: check database to match credentials, update database - user session 
                    
                    //send response to client
                    if(true) {// TODO: test if user data is corrects
                        loggedIn = true;
                        sessionId = UUID.randomUUID();
                        code = ServerResponse.REQUEST_SUCCEEDED;
                    }
                    response = new ServerResponse<UUID>("Logged in successfully", ServerResponse.REQUEST_SUCCEEDED, sessionId);
                    objectOutputStream.writeObject(response);
                }
                case ServerRequest.USER_LOGOUT_COMMAND -> {
                    //Actions for user logout
                }
                case ServerRequest.USER_REGISTER_COMMAND -> {
                    //Actions to register user
                }
                case ServerRequest.USER_LIVE_CHAT_COMMAND -> {

                    sessionId = UUID.randomUUID();

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
