import java.io.*;
import java.net.*;

public class Exercise35_Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String msgFromServer, msgFromClient;

            while (true) {
                // Get client input and send to server
                System.out.print("Client: ");
                msgFromClient = userInput.readLine();
                out.println(msgFromClient);
                if (msgFromClient.equalsIgnoreCase("bye")) {
                    System.out.println("You ended the chat.");
                    break;
                }

                // Read message from server
                msgFromServer = in.readLine();
                if (msgFromServer == null || msgFromServer.equalsIgnoreCase("bye")) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Server says: " + msgFromServer);
            }

            System.out.println("Client closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
