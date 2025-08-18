package com.meli.challenge.item_comparison_api.exception_handler;


import com.meli.challenge.item_comparison_api.exception.EmptyListException;
import com.meli.challenge.item_comparison_api.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.badRequest().body("Invalid parameter ID type: " + ex.getMessage());
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<String> handleEmptyListException(EmptyListException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
