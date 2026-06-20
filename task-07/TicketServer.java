import java.net.ServerSocket;
import java.net.Socket;

public class TicketServer {
    private final TicketService service = new TicketService();

    public void start(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            while (true) {
                Socket client = server.accept();
                new ClientHandler(client, service).start();
            }
        }
        catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new TicketServer().start(5000);
    }
}
