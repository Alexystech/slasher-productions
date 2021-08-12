package com.slasher.slasherproductions.service.exception;

public class SongByAlbumNotFoundException extends RuntimeException{

    public static SongByAlbumNotFoundException of(long idAlbum) {
        return new SongByAlbumNotFoundException(idAlbum);
    }

    public SongByAlbumNotFoundException(String message) {
        super(message);
    }

    private SongByAlbumNotFoundException(long idAlbum) {
        super(String.format("Songs with id %d was not found",
                idAlbum));
    }

}
