import javax.swing.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private ServerSocket serverSocket;
    private Socket connectionSocket;
    private static Connection dBConn = null;
    private Statement stmt;
    private ResultSet result = null;
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public Server() {
        this.createConnection();
        this.waitForRequests();
    }

    private void createConnection() {
        try {
            //New instance of the ServerSocket listening on port 8888
            serverSocket = new ServerSocket(8888);
            //Information logger saying Server waiting for client connection
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void configureStreams() {
        try {
            //Instantiate the output stream using the getOutputStream method of Socket object
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
            //Instantiate the input stream using the getInputStream method od socket object
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
        }catch (IOException ex) {
            ex.printStackTrace();
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

    //private void addClientToFile(Student student) { }

    //private Student findClientById(String stuId) { }

    private void waitForRequests() {
        String action = "";
        getDatabaseConnection();
        try {
            while (true) {
                connectionSocket = serverSocket.accept();
                this.configureStreams();
                try {
                    //stmt = dBConn.createStatement();
                    //result = s.executeQuery("SELECT * FROM user");
                   /* if(rs.next()){
                        System.out.println(rs.getString(2));
                    } */
                    action = (String) objIs.readObject();
                }catch (ClassNotFoundException | ClassCastException ex) {
                    ex.printStackTrace();
                }
                this.closeConnection();
            }
        }catch (EOFException ex) {
            System.out.println("Client has terminated connections with the server");
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
