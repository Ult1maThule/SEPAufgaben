import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    final private Socket socket;
    final private BufferedReader bufferedReader;
    final private BufferedWriter bufferedWriter;
    private static String username;

    public Client(Socket socket, String username) throws IOException {
        this.socket = socket;
        Client.username = username;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public void output() throws IOException {
        Scanner scanner = new Scanner(System.in);

        bufferedWriter.write(username);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        while(socket.isConnected()) {
            String message = scanner.nextLine();
            bufferedWriter.write(username+": "+message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    public void input() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String message;

                try {
                    while(socket.isConnected()) {
                        message = bufferedReader.readLine();
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client name: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 1000);
        Client client = new Client(socket, username);

        client.input();
        client.output();
    }
}