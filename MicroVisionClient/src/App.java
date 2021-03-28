import utilities.*;

import java.net.Authenticator;

import models.users.*;

public class App {
    public static Client clientConnection; //socket connection for general purpose use in the app
    public static Client messageConnection; //socket connection for use with chat
    public static _User user; // the currently logged in user
    public static String sessionId; //identifies a session based on user-id and a random string 

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        clientConnection = new Client();
        Authentication auth =  new Authentication();
        auth.login("Marvin", "Gordon"); 
        System.out.println("Hello, World!");
    }
}
