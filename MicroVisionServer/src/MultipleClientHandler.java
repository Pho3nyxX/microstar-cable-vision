import utilities.ServerRequest;

import java.io.IOException;
import java.net.Socket;

public class MultipleClientHandler extends Server implements Runnable {

    public MultipleClientHandler(Socket socketObject) {
        this.connectionSocket = socketObject;
    }

    @Override
    public void run() {
        ServerRequest action;
        try {
            this.configureStreams();
            //stmt = dBConn.createStatement();
            //result = s.executeQuery("SELECT * FROM user");
                   /* if(rs.next()){
                        System.out.println(rs.getString(2));
                    } */
            connection.warn("Attempting to receive data from client");
            action = (ServerRequest) objectInputStream.readObject();
            connection.info("Data successfully received from client");
            //System.out.println(action.getClass());
            switch (action.getCommand()) {
                case "User-Login" -> {
                    //Actions for user login
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
