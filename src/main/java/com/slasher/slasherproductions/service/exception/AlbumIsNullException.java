package com.slasher.slasherproductions.service.exception;

public class AlbumIsNullException extends RuntimeException {

    public static AlbumIsNullException of() {
        return new AlbumIsNullException();
    }

    public AlbumIsNullException(String message) {
        super(message);
    }

    private AlbumIsNullException() {
        super("Album is null");
    }
}
