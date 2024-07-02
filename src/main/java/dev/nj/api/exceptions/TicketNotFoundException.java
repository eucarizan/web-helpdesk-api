package dev.nj.api.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(long ticketId) {
        super("ticket with id %d not found".formatted(ticketId));
    }
}
