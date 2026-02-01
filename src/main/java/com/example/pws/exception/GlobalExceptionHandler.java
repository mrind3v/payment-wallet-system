package com.example.pws.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        // 1. Create the response body
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage()); // This gets the message you passed to the exception
        response.put("status", HttpStatus.NOT_FOUND.value());

        // 2. Return the Map with a 404 Not Found status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(InvalidAmountException ex) {
        // 1. Create the response body
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage()); // This gets the message you passed to the exception
        response.put("status", HttpStatus.NOT_FOUND.value());

        // 2. Return the Map with a 404 Not Found status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(UnauthorizedAccessException ex) {
        // 1. Create the response body
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("message", ex.getMessage()); // This gets the message you passed to the exception
        response.put("status", HttpStatus.NOT_FOUND.value());

        // 2. Return the Map with a 404 Not Found status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFound(MethodArgumentNotValidException ex) {
        // 1. Create the response body

        HashMap<String, String > errors= new HashMap<String, String >() ;
        ex.getBindingResult().getAllErrors().forEach((error )-> {
            String fieldName= ((FieldError ) error ).getField() ;
            String errorMessage= error.getDefaultMessage() ;
            errors.put(fieldName, errorMessage ) ;
        } ) ;
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("errors", errors ); // This gets the message you passed to the exception
        response.put("status", HttpStatus.NOT_FOUND.value()) ;

        // 2. Return the Map with a 404 Not Found status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}