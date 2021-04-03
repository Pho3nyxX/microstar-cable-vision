import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import utilities.communication._ClientServer;
// import models.users.*;

public class Server extends _ClientServer {
    private ServerSocket serverSocket;
    private static int clientCount=0;
    private static Connection dBConn = null;
    private Statement stmt;
    private ResultSet result = null;
    private static ExecutorService pool = Executors.newFixedThreadPool(10); //Limit users to 10
    private static ArrayList<MultipleClientHandler> clientHandlerArrayList = new ArrayList<>();

    public Server() {
        this.createConnection();
        this.waitForRequests();
    }

    public static List<MultipleClientHandler> getClientHandlerList() {
        return clientHandlerArrayList;
    }
    
    public void createConnection() {
        try {
            //New instance of the ServerSocket listening on port 9097
            connection.warn("Attempting to set up the Server Socket");
            serverSocket = new ServerSocket(SERVERPORT);
            connection.info("Server Socket set-up successfully");
        }catch (IOException ex) {
            System.out.println("Socket not created");
            error.error(ex.getMessage());
        }
    }
    
    public static void getDatabaseConnection() {
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
    }
    
    private void waitForRequests() {
        //getDatabaseConnection();
        try {
            while (true) {
                connection.info("Server waiting for connections");
                connectionSocket = serverSocket.accept();
                connection.info("Client request accepted");
                clientCount++;
                System.out.println("constructor");
                connection.info("Clients currently on server: " + clientCount);

                MultipleClientHandler clientHandler = new MultipleClientHandler(this.connectionSocket);
                clientHandlerArrayList.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (EOFException ex) {
            connection.info("Client has terminated connections with the server");
            error.error(ex.getMessage());
            //System.out.println(ex.getMessage());
        }catch (IOException ex) {
            error.error(ex.getMessage());
            //System.out.println(ex.getMessage());
        }catch (Exception ex) {
            error.error(ex.getMessage());
            System.out.println(ex.getMessage());
        }finally{
            this.closeConnection();
        }
    }
}

