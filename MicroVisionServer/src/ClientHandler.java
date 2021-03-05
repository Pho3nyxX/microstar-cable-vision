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
            String clientRequest = in.readLine();

            while (clientRequest.compareTo("EXIT")!=0) {
                if (clientRequest.contains("hi")) {
                    out.println("Hello, I am a Server");
                } else {
                    out.println("Anything else to say?");
                }
                clientRequest = in.readLine();
            }
            //When the try block is closed or server is manually closed, it will jump into finally block to close resources.
            System.out.println("Server sent message/s. Closing.");
            in.close();
            out.close();
            client.close();
        }catch (IOException ex) {
            System.out.println("IO Exception in client handler");
            ex.printStackTrace();
        }
    }
}
