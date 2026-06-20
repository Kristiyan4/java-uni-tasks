import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket socket;
    private final TicketService service;
    private User currentUser;

    public ClientHandler(Socket socket, TicketService service) {
        this.socket = socket;
        this.service = service;
    }

    private void ensureLoggedIn() {
        if (currentUser == null) throw new NotLoggedInException();
    }

    private void ensureRole(UserRole role) {
        if (currentUser.getRole() != role) throw new PermissionDeniedException();
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String line;

            while ((line = in.readLine()) != null) {
                try {
                    String[] p = line.split(" ", 5);

                    if (p[0].equals("LOGIN")) {
                        if (p[1].equals("CUSTOMER")) {
                            currentUser = new Customer(p[2], p[3], p[4]);
                            out.println("LOGGED CUSTOMER");
                        } else if (p[1].equals("SUPPORT")) {
                            currentUser = new Support(p[2], p[3], p[4]);
                            out.println("LOGGED SUPPORT");
                        } else throw new InvalidCommandException();
                    }

                    else if (p[0].equals("CREATE")) {
                        ensureLoggedIn();
                        ensureRole(UserRole.CUSTOMER);
                        Ticket t = service.createTicket((Customer) currentUser, p[1]);
                        out.println("CREATED " + t.getId());
                    }

                    else if (p[0].equals("INBOX")) {
                        ensureLoggedIn();
                        ensureRole(UserRole.SUPPORT);
                        for (Ticket t : service.listTickets())
                            out.println(t.getId() + " " + t.getStatus());
                        out.println("END");
                    }

                    else if (p[0].equals("READ")) {
                        ensureLoggedIn();
                        ensureRole(UserRole.SUPPORT);
                        service.markRead(Integer.parseInt(p[1]));
                        out.println("READ_OK");
                    }

                    else if (p[0].equals("RESOLVE")) {
                        ensureLoggedIn();
                        ensureRole(UserRole.SUPPORT);
                        service.resolve(Integer.parseInt(p[1]));
                        out.println("RESOLVED_OK");
                    }

                    else if (p[0].equals("EXIT")) {
                        break;
                    }

                    else {
                        throw new InvalidCommandException();
                    }

                } catch (RuntimeException ex) {
                    out.println("ERR " + ex.getMessage());
                }
            }

            socket.close();
        }
        catch (Exception e) {
        }
    }
}
