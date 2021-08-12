package com.slasher.slasherproductions.service.exception;

public class ArtistNotFoundException extends RuntimeException{

    public static ArtistNotFoundException of(long idArtist) {
        return new ArtistNotFoundException(idArtist);
    }

    public ArtistNotFoundException(String message) {
        super(message);
    }

    private ArtistNotFoundException(long idArtist) {
        super(String.format("Artist with id %d was not found",
                idArtist));
    }

}
