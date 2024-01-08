package com.nick.payment.integration.exception;

public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException() {
        super("Username is Already there");
    }
}
