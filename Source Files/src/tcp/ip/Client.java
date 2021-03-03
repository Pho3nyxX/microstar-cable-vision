package tcp.ip;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    private static final String SERVERIP = "127.0.0.1";
    private static final int SERVERPORT = 9097;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVERIP, SERVERPORT);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String serverResponse = input.readLine();

        JOptionPane.showMessageDialog(null, serverResponse);

        socket.close();
        System.exit(0);
    }
}
