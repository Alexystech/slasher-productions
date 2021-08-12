package com.slasher.slasherproductions.service.exception;

public class AuthorIsNullException extends RuntimeException {

    public static AuthorIsNullException of() {
        return new AuthorIsNullException();
    }

    public AuthorIsNullException(String message) {
        super(message);
    }

    private AuthorIsNullException() {
        super("Author is null");
    }

}
