package tcp.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9097;

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("Server is waiting for client connection...");
        Socket client = listener.accept(); //Make connection here

        System.out.println("Server connected to client");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        try {
            while (true) {
                String clientRequest = in.readLine();

                if (clientRequest.contains("hi")) {
                    out.println("Hello, I am a Server");
                } else {
                    out.println("Anything else to say?");
                }
            }
        }finally { //When the try block is closed or server is manually closed, it will jump into finally block to close resources.
            System.out.println("Server sent message/s. Closing.");
            client.close();
            listener.close();
        }
    }
}
