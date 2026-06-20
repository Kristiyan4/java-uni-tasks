import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;

        if (args.length >= 1) {
            host = args[0];
        }
        if (args.length >= 2) {
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Невалиден порт, използвам по подразбиране: " + port);
            }
        }

        System.out.println("Свързване към " + host + ":" + port + "...");

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(
                     new InputStreamReader(System.in))) {

            System.out.println("Свързването е успешно. Пишете съобщения (\"exit\" за край).");

            while (true) {
                System.out.print("Вие (клиент): ");
                String clientMsg = console.readLine();
                if (clientMsg == null) {
                    System.out.println("Няма вход от конзолата. Спирам.");
                    break;
                }

                out.println(clientMsg);

                if ("exit".equalsIgnoreCase(clientMsg)) {
                    System.out.println("Изпратихте команда за изход. Затварям клиента.");
                    break;
                }

                String serverReply = in.readLine();
                if (serverReply == null) {
                    System.out.println("Сървърът прекъсна връзката.");
                    break;
                }

                System.out.println("Сървър: " + serverReply);
            }

        } catch (IOException e) {
            System.out.println("Грешка в клиента: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Клиентът спря.");
    }
}