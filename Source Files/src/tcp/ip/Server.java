package tcp.ip;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 9097;

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);

        System.out.println("Server is waiting for client connection");
        Socket client = listener.accept();

        System.out.println("Server connected to client");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        out.println("I am a Server");
        System.out.println("Server sent message. Closing.");

        client.close();
        listener.close();
    }
}
