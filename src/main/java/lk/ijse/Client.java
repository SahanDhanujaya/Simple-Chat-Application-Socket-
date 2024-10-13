package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                // Connect to server
                Socket socket = new Socket("localhost", 3000);

                // Request to server
                System.out.print("Client: ");
                String message = scanner.nextLine();  // Use nextLine() to capture the full message
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message);

                // Send the data
                dataOutputStream.flush();

                // Receive the response
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println("Server: " + dataInputStream.readUTF());

                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
