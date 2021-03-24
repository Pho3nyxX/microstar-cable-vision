/* For all Client Related Communication */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private static final String SERVERIP = "127.0.0.1";
    private static final int SERVERPORT = 9097;
    private static ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private Socket connectionSocket;
    String action = "";

    public Client() {
        this.createConnection();
        this.configureStreams();
    }

    private void createConnection() {
        try {
            //Create a socket to connect to the server
            connectionSocket = new Socket(SERVERIP, SERVERPORT);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void configureStreams() {
        try {
            //Create an input stream to receive data from the server
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
            //Create an output stream to send data to the server
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void sendAction(String action) {
        this.action = action;
        try {
            objOs.writeObject(action);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //public void sentClient() {}

    //public void sentClientId() {}

    public void receiveResponse() { }

    public void closeConnection() {
        try {
            objOs.close();
            objIs.close();
            connectionSocket.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
