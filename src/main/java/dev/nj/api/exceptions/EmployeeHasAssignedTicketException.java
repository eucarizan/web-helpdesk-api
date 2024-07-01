package dev.nj.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeHasAssignedTicketException extends RuntimeException {
    public EmployeeHasAssignedTicketException() {
        super("employee has assigned ticket(s) and cannot be deleted");
    }
}
