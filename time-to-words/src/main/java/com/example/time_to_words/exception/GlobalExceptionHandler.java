package com.example.time_to_words.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidTimeFormatException.class)
    public ResponseEntity<String> handleInvalidFormat(InvalidTimeFormatException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}

