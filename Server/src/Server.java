import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        int count = 0;
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted" + (++count));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));

            String request = reader.readLine();
            Thread.sleep(3000);
            String response = "#" + count + "requst len" + request.length();

            writer.write(response);
            writer.newLine();
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }

    }

}
