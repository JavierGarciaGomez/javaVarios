package Interactive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        DataInputStream input = new DataInputStream(client.getInputStream());

        try{
            while(true){
                String request = input.readUTF();
                if (request.contains("name")){
                    output.writeUTF("ESTO ES UN NOMBRE");
                } else {
                    output.writeUTF("Type 'tell me a name'");
                }
            }
        } finally {
            output.close();
            input.close();
        }
    }
}
