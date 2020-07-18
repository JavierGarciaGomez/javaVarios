package SingleInteraction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static final int PORT = 9090;

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(PORT);
        System.out.println("[SERVER] Waiting for client connection");
        Socket client = listener.accept();
        System.out.println("[SERVER] Connected to client");
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        output.writeUTF((new Date()).toString());
        System.out.println("[SERVER]  Sent date. Closing.");

        client.close();
        listener.close();


    }
}
