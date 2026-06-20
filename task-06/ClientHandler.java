import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread{
    private Socket socket;
    private List<ParkingSpot> spots;

    public ClientHandler(Socket socket, List <ParkingSpot> spots)
    {
        this.socket = socket;
        this.spots = spots;

    }
public void handleTake (int id, String name, PrintWriter out)
{
    synchronized (spots)
    {
        for (ParkingSpot p : spots) {
            if (p.getId() == id) {
                if (p.take(name)) {
                    out.println("Taken successful");
                } else {
                    out.println("already taken");
                }
                return;
            }
        }
    }
    out.println("No such parking spot");
}
public void handleFree(int id, PrintWriter out)
{
   synchronized (spots)
   {
       for (ParkingSpot p : spots)
       {
           if(p.getId() == id)
           {
               if(p.free())
               {
                   out.println("Free successful");
               }
               else {
                   out.println("Already free");
               }
               return;
           }
       }
   }
   out.println("No such parking spot");
}

@Override
public void run()
{
    try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream()))
    {
        out.println("Connected");
        out.println("Chose a number: 1, 2, 3");
        String line;
        while ((line = in.readLine()) != null)
        {
            String[] parts = line.split(" ");
            int choise = Integer.parseInt(parts[0]);

            switch (choise)
            {
                case 1:
                    synchronized (spots)
                    {
                        for (ParkingSpot p : spots)
                        {
                            out.println(p);
                        }
                        break;
                    }
                case 2:
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    handleTake(id, name, out);
                    break;
                case 3:
                    int freeid = Integer.parseInt(parts[1]);
                    handleFree(freeid, out);
                default:
                    out.println("No such choice");

            }
        }
    }
    catch (IOException e)
    {
        throw new RuntimeException(e);
    }
}
}
