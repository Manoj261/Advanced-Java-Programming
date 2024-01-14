import java.io.*;
import java.net.*;

public class TranslatingServer {
    public static void main(String[] args) {
        int portNumber = 1341;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is waiting for client connections on port " + portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from client: " + clientSocket.getInetAddress());
                Thread clientThread = new Thread(() -> handleClient(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void handleClient(Socket clientSocket) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String name = reader.readLine();
            System.out.println("Received name from client: " + name);
            String translatedName = name.toUpperCase();
            writer.println(translatedName);
            System.out.println("Sent translated name to client: " + translatedName);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
