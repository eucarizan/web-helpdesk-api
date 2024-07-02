package dev.nj.api.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("employee does not exists");
    }
}
