import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket clientsocket =
                new Socket("127.0.0.1", 8000);

        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        clientsocket.getOutputStream()));

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientsocket.getInputStream()));

        writer.write("Get me some information");
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);

        writer.close();
        reader.close();
        clientsocket.close();
    }
}