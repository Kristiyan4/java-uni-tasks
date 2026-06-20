public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException() {
        super("TICKET_NOT_FOUND");
    }
}

