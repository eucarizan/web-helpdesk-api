package dev.nj.api.exceptions;

public class EmployeeAlreadyWatchingTicketException extends RuntimeException {
    public EmployeeAlreadyWatchingTicketException(String message) {
        super(message);
    }
}
