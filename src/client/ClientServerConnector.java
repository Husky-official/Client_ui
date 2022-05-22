package src.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientServerConnector {
    public String connect(String requestBody) {
        try{
            Socket socket = new Socket("localhost", 8888);
            DataOutputStream requestOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream responseIn = new DataInputStream(socket.getInputStream());

            requestOut.writeUTF(String.valueOf(requestBody));

            return responseIn.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
