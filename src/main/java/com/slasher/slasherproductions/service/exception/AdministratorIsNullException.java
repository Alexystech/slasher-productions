package com.slasher.slasherproductions.service.exception;

public class AdministratorIsNullException extends RuntimeException{

    public static AdministratorIsNullException of() {
        return new AdministratorIsNullException();
    }

    public AdministratorIsNullException(String message) {
        super(message);
    }

    private AdministratorIsNullException() {
        super("Administrator is null");
    }
}
