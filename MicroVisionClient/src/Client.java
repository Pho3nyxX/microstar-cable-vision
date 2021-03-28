/* For all Client Related Communication */

import utilities.communication._ClientServer;
import utilities.ServerRequest;
import utilities.ServerResponse;

import java.io.IOException;
import java.net.Socket;

public class Client extends _ClientServer {
    String SERVERIP = "127.0.0.1";


    public Client() {
        this.createConnection();
        this.configureStreams();
    }

    public void createConnection() {
        try {
            connection.warn("Attempting to setup client socket");
            //Create a socket to connect to the server
            this.connectionSocket = new Socket(SERVERIP, SERVERPORT);
            connection.info("Socket setup successful");
        }catch (IOException ex) {
            error.error(ex.getMessage());
        }
    }

    public void sendAction(ServerRequest action) {
        // this.action = action;
        try {
            connection.warn("Attempting to send action to the Server");
            objectOutputStream.writeObject(action);
            connection.info("Action successfully sent to Server");
            System.out.println("Action successfully sent to Server");
        }catch (IOException ex) {
            error.warn("Action not sent to Server \n" + ex.getMessage());
        }
    }

    public ServerResponse receiveResponse() {
        ServerResponse response = null;
        try {
            connection.warn("Attempting to receive response from server");
            response = (ServerResponse) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException ex) {
            error.error(ex.getMessage());
        }
        return response;
    }
}
/*
public ServerResponse receiveResponse() { 
    ServerResponse response = null;
    // this.action = action;
    try {
        response = (ServerResponse)objIs.readObject();
    }catch (ClassNotFoundException | ClassCastException ex) {
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }catch(SocketException ex){
        ex.printStackTrace();
        System.out.println(ex.getMessage());
    }catch (IOException ex) {
        ex.printStackTrace();
    }
    */