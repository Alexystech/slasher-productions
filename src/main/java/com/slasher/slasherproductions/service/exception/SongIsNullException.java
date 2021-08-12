package com.slasher.slasherproductions.service.exception;

public class SongIsNullException extends RuntimeException{

    public static SongIsNullException of() {
        return new SongIsNullException();
    }

    public SongIsNullException(String message) {
        super(message);
    }

    private SongIsNullException() {
        super("Song is null");
    }

}
