package com.slasher.slasherproductions.service.exception;

public class ArtistIsNullException extends RuntimeException{

    public static ArtistIsNullException of() {
        return new ArtistIsNullException();
    }

    public ArtistIsNullException(String message) {
        super(message);
    }

    private ArtistIsNullException() {
        super("Artist is null");
    }

}
