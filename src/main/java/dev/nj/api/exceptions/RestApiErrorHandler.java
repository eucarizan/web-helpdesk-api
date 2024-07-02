package dev.nj.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class RestApiErrorHandler {

    @ExceptionHandler(value = {
            EmployeeNotFoundException.class,
            TicketNotFoundException.class})
    ResponseEntity<Object> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {
            EmployeeHasAssignedTicketException.class,
            TicketAlreadyAssignedException.class,
            EmployeeAlreadyWatchingTicketException.class
    })
    ResponseEntity<Object> handleBadRequestException(RuntimeException ex) {
        return new ResponseEntity<>(Map.of("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
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
