import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        System.out.println("Сървърът стартира на порт " + PORT + "...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Чакаме клиент да се свърже...");
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader console = new BufferedReader(
                         new InputStreamReader(System.in))) {

                System.out.println("Клиент се свърза: " + clientSocket.getInetAddress());

                String clientMsg;
                while (true) {
                    clientMsg = in.readLine();
                    if (clientMsg == null) {
                        System.out.println("Клиентът прекъсна връзката.");
                        break;
                    }

                    System.out.println("Клиент: " + clientMsg);

                    if ("exit".equalsIgnoreCase(clientMsg)) {
                        System.out.println("Получена команда за изход. Затварям сървъра.");
                        break;
                    }

                    System.out.print("Вие (сървър): ");
                    String serverMsg = console.readLine();
                    if (serverMsg == null) {
                        System.out.println("Няма вход от конзолата. Спирам.");
                        break;
                    }

                    out.println(serverMsg);

                    if ("exit".equalsIgnoreCase(serverMsg)) {
                        System.out.println("Изпратена команда за изход към клиента. Затварям сървъра.");
                        break;
                    }
                }

            }

        } catch (IOException e) {
            System.out.println("Грешка в сървъра: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Сървърът спря.");
    }
}