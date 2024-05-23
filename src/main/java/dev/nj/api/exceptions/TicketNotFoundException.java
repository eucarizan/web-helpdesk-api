package dev.nj.api.exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException() {
        super("ticket not found");
    }
}
