package com.slasher.slasherproductions.service.exception;

public class SongByAuthorNotFoundException extends RuntimeException{

    public static SongByAuthorNotFoundException of(long idAuthor) {
        return new SongByAuthorNotFoundException(idAuthor);
    }

    public SongByAuthorNotFoundException(String message) {
        super(message);
    }

    private SongByAuthorNotFoundException(long idAuthor) {
        super(String.format("Songs with id %d was not found",
                idAuthor));
    }
}
