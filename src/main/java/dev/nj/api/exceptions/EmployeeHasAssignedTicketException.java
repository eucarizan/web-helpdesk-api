package dev.nj.api.exceptions;

public class EmployeeHasAssignedTicketException extends RuntimeException {
    public EmployeeHasAssignedTicketException(long id) {
        super("employee with id %d has assigned ticket(s) and cannot be deleted".formatted(id));
    }
}
