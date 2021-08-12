package com.slasher.slasherproductions.service.exception;

public class UserNotFoundException extends RuntimeException{

    public static UserNotFoundException of(long idUser) {
        return new UserNotFoundException(idUser);
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    private UserNotFoundException(long idUser) {
        super(String.format("User with id %d was not found",
                idUser));
    }
}
