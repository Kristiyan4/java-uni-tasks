import java.time.LocalDateTime;

public class Ticket {
    private final int id;
    private final Customer customer;
    private final String content;
    private volatile TicketStatus status;
    private final LocalDateTime createdAt;
    private volatile LocalDateTime resolvedAt;

    public Ticket(int id, Customer customer, String content) {
        this.id = id;
        this.customer = customer;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.status = TicketStatus.OPEN;
    }

    public int getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void markRead() {
        if (status == TicketStatus.OPEN) status = TicketStatus.READ;
    }

    public void resolve() {
        status = TicketStatus.RESOLVED;
        resolvedAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public Customer getCustomer() {
        return customer;
    }
}
