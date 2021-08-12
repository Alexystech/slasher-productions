package com.slasher.slasherproductions.service.exception;

public class MusicalGroupIsNullException extends RuntimeException{

    public static MusicalGroupIsNullException of() {
        return new MusicalGroupIsNullException();
    }

    public MusicalGroupIsNullException(String message) {
        super(message);
    }

    private MusicalGroupIsNullException() {
        super("The musical group is null");
    }
}
