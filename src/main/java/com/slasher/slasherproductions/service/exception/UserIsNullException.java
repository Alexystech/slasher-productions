package com.slasher.slasherproductions.service.exception;

public class UserIsNullException extends RuntimeException{

    public static UserIsNullException of() {
        return new UserIsNullException();
    }

    public UserIsNullException(String message) {
        super(message);
    }

    private UserIsNullException() {
        super("User is null");
    }
}
