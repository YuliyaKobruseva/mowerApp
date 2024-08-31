package com.example.mowerApp.domain.exception;

public class InvalidDirectionException extends RuntimeException {
    public InvalidDirectionException(String message) {
        super(message);
    }
}
