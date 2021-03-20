import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.sql.Statement;

public class Server {

    private static final int PORT = 9097;
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        //ServerSocket listener = new ServerSocket(PORT);
        //System.out.println("Server is waiting for client connection...");

        try{
            // Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/microstarcablevision", "ap_project_user", "&L&cTM1nuT&$258");
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM user");
            
            if(rs.next()){
                System.out.println(rs.getString(2));
            }
            con.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
/*
        while (true) {
            Socket client = listener.accept(); //Make connection here
            System.out.println("Server connected to client");

            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
            pool.execute(clientThread);
        }
        */
    }
}
