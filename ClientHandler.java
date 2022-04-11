import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    final private Socket socket;
    final private BufferedReader bufferedReader;
    final private BufferedWriter bufferedWriter;
    private String username;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.username = bufferedReader.readLine();

        clientHandlers.add(this);
    }

    @Override
    public void run() {
        while(socket.isConnected()) {
            String message;
            try {
                message = bufferedReader.readLine();
                print(message);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(String message) throws IOException {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.bufferedWriter.write(message);
            clientHandler.bufferedWriter.newLine();
            clientHandler.bufferedWriter.flush();
        }
    }
}
