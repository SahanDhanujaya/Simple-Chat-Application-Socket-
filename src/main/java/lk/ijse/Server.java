package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        try {
            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
                //local socket
                Socket socket = serverSocket.accept();//accept the request from serve socket
                System.out.println("Client accepted");
                //data reading option
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                System.out.println(dataInputStream.readUTF());//sout

                System.out.print("Server : ");
                String input = scanner.nextLine();
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                //sending message
                outputStream.writeUTF(input);
                outputStream.flush();

                //close
                socket.close();

        }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
