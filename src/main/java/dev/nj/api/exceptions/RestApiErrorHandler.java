package dev.nj.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestApiErrorHandler {

    @ExceptionHandler(TicketNotFoundException.class)
    ResponseEntity<Object> handleTicketNotFoundException(TicketNotFoundException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeHasAssignedTicketException.class)
    ResponseEntity<Object> handleEmployeeHasTicketAssignedException(EmployeeHasAssignedTicketException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TicketAlreadyAssignedException.class)
    ResponseEntity<Object> handleTicketAlreadyAssignedException(TicketAlreadyAssignedException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeAlreadyWatchingTicketException.class)
    ResponseEntity<Object> handleEmployeeAlreadyWatchingTicketException(EmployeeAlreadyWatchingTicketException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    //    @ResponseStatus(HttpStatus.BAD_REQUEST) public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName =((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }
}
