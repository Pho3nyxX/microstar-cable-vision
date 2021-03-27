import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utilities.communication._ClientServer;
import utilities.*;
// import models.users.*;

public class Server extends _ClientServer {
    private ServerSocket serverSocket;
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public Server() {
        this.createConnection();
        this.waitForRequests();
    }

    public void createConnection() {
        try {
            //New instance of the ServerSocket listening on port 9097
            connection.warn("Attempting to set up the Server Socket");
            serverSocket = new ServerSocket(SERVERPORT);
            connection.info("Server Socket set-up successfully");
        }catch (IOException ex) {
            error.error(ex.getMessage());
        }
    }

    public static Connection getDatabaseConnection() {
        if (dBConn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/microstarvision?useSSL=false";
                dBConn = DriverManager.getConnection(url,"ap_project_user","&L&TM1nuT&$258");

                JOptionPane.showMessageDialog(null,"DB Connection Established", "Connection Status",
                        JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Could not connect to database\n" +
                        ex,"Connection Failure",JOptionPane.ERROR_MESSAGE);
            }
        }
        return dBConn;
    }

    private void waitForRequests() {
        ServerRequest action;
        //getDatabaseConnection();
        try {
            while (true) {
                connection.info("Server waiting for connections");
                connectionSocket = serverSocket.accept();
                connection.info("Client request accepted");
                this.configureStreams();
                try {
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
                }catch (ClassNotFoundException | ClassCastException | SocketException ex) {
                    error.error(ex.getMessage());
                    //System.out.println(ex.getMessage());
                } finally{
                    this.closeConnection();
                }
            }
        }catch (EOFException ex) {
            System.out.println("Client has terminated connections with the server");
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }catch (IOException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }
}
