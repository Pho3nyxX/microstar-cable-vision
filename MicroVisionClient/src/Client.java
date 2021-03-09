/* For all Client Related Communication */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private static final String SERVERIP = "127.0.0.1";
    private static final int SERVERPORT = 9097;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVERIP, SERVERPORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String command;

        while (true) {
            System.out.println("Enter Data to sent to server or EXIT to leave.");
            System.out.println("Input: ");
            command = keyboardInput.readLine();

            if (command.equals("EXIT")) {
                break;
            }

            out.println(command);

            String serverResponse = input.readLine();
            System.out.println("Server says: " + serverResponse);
        }
        out.println(command);
        //JOptionPane.showMessageDialog(null, serverResponse);

        input.close();
        keyboardInput.close();
        out.close();
        socket.close();
        System.exit(0);
    }
}
