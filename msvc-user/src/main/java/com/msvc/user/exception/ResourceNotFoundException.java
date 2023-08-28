package com.msvc.user.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not found in this server ...");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
