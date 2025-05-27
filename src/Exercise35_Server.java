import java.io.*;
import java.net.*;

public class Exercise35_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String msgFromClient, msgFromServer;

            while (true) {
                // Read message from client
                msgFromClient = in.readLine();
                if (msgFromClient == null || msgFromClient.equalsIgnoreCase("bye")) {
                    System.out.println("Client disconnected.");
                    break;
                }
                System.out.println("Client says: " + msgFromClient);

                // Get server input and send to client
                System.out.print("Server: ");
                msgFromServer = userInput.readLine();
                out.println(msgFromServer);
                if (msgFromServer.equalsIgnoreCase("bye")) {
                    System.out.println("You ended the chat.");
                    break;
                }
            }

            clientSocket.close();
            System.out.println("Server closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
