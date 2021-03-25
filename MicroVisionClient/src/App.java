import utilities.*;
public class App {
    public static Client clientConnection;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        clientConnection = new Client();
        Customer user =  new Customer();
        user.login("Marvin", "Gordon"); 
    }
}
