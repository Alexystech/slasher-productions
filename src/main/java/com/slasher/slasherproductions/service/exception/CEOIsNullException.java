package com.slasher.slasherproductions.service.exception;

public class CEOIsNullException extends RuntimeException{

    public static CEOIsNullException of() {
        return new CEOIsNullException();
    }

    public CEOIsNullException(String message) {
        super(message);
    }

    private CEOIsNullException() {
        super("CEO is null");
    }

}
