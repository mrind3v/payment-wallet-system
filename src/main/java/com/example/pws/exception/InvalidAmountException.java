package com.example.pws.exception;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String exception) {
        super(exception);
    }
}
