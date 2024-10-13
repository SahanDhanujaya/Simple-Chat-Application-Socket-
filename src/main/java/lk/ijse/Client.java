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
                //remote socket
                Socket socket = new Socket("localhost", 3000);

                //request to server
                System.out.print("Client : ");
                String message = scanner.next();
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message);

                //send the data
                dataOutputStream.flush();
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());

                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }while (true);
    }
}
