import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ParkingServer {
    public static void main(String [] args)
    {
        List<ParkingSpot> spots = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            spots.add(new ParkingSpot(i, 100 + i));
        }
        try (ServerSocket serverSocket = new ServerSocket(1643))
        {
            while(true)
            {
                Socket client = serverSocket.accept();
                new ClientHandler(client, spots).start();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
