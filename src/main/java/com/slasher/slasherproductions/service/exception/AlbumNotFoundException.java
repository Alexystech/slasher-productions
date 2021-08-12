package com.slasher.slasherproductions.service.exception;

public class AlbumNotFoundException extends RuntimeException{

    public static AlbumNotFoundException of(long idAlbum) {
        return new AlbumNotFoundException(idAlbum);
    }

    public AlbumNotFoundException(String message) {
        super(message);
    }

    private AlbumNotFoundException(long idAlbum) {
        super(String.format("Album with id %d was not found",
                idAlbum));
    }

}
