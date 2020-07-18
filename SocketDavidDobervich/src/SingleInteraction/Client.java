package SingleInteraction;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private static final String SERVER_IP="127.0.0.1";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        String serverResponse = input.readUTF();
        System.out.println(serverResponse);
        socket.close();



    }
}
