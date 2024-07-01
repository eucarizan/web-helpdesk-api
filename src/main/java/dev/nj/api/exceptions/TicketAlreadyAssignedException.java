package dev.nj.api.exceptions;

public class TicketAlreadyAssignedException extends RuntimeException{
    public TicketAlreadyAssignedException(String message) {
        super(message);
    }
}
