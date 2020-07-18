package Interactive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP="127.0.0.1";
    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(SERVER_IP, SERVER_PORT);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);

        while(true){
            String command = scanner.nextLine();
            if (command.equals("quit")) break;
            output.writeUTF(command);
            String serverResponse = input.readUTF();
            System.out.println(serverResponse);
            socket.close();

        }
    }
}
