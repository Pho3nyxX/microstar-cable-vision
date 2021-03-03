package tcp.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String clientRequest = in.readLine();

                if (clientRequest.contains("hi")) {
                    out.println("Hello, I am a Server");
                } else {
                    out.println("Anything else to say?");
                }
            }
        }catch (IOException ex) {
            System.out.println("IO Exception in client handler");
            ex.printStackTrace();
        }finally {
            //When the try block is closed or server is manually closed, it will jump into finally block to close resources.
            System.out.println("Server sent message/s. Closing.");
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
