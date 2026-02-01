package com.example.pws.exception;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(String exception) {
        super(exception);
    }
}
