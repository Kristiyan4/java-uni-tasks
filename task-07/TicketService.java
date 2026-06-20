import java.util.Map;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketService {
    private final AtomicInteger idGen = new AtomicInteger(1);
    private final Map<Integer, Ticket> tickets = new ConcurrentHashMap<>();

    public Ticket createTicket(Customer c, String content) {
        Ticket t = new Ticket(idGen.getAndIncrement(), c, content);
        tickets.put(t.getId(), t);
        return t;
    }

    public Collection<Ticket> listTickets() {
        return tickets.values();
    }

    public Ticket getTicket(int id) {
        Ticket t = tickets.get(id);
        if (t == null) throw new TicketNotFoundException();
        return t;
    }

    public void markRead(int id) {
        Ticket t = tickets.get(id);
        if (t == null) throw new TicketNotFoundException();
        t.markRead();
    }

    public void resolve(int id) {
        Ticket t = tickets.get(id);
        if (t == null) throw new TicketNotFoundException();
        t.resolve();
    }
}
