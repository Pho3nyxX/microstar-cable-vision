package utilities.communication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class _ClientServer {
    protected ObjectOutputStream objectOutputStream;
    protected ObjectInputStream objectInputStream;
    protected Socket connectionSocket;
    protected final int SERVERPORT = 9097;
    protected Logger connection = LogManager.getLogger("Connection");
    protected Logger error = LogManager.getLogger("Error");

    public abstract void createConnection();

    protected void configureStreams() {
        try {
            //Create an input stream to receive data from the server and client
            connection.warn("Attempting to setup streams");
            objectInputStream = new ObjectInputStream(connectionSocket.getInputStream());
            //Create an output stream to send data to the server and client
            objectOutputStream = new ObjectOutputStream(connectionSocket.getOutputStream());
            connection.info("Streams setup successfulyy");
        }catch (IOException ex) {
            error.error(ex.getMessage());
        }
    }
    protected void closeConnection() {
        try {
            connection.warn("Attempting to close streams");
            objectOutputStream.close();
            objectInputStream.close();
            connectionSocket.close();
            connection.info("Streams closed successfully");
        }catch (IOException ex) {
            error.error(ex.getMessage());
        }
    }
}
