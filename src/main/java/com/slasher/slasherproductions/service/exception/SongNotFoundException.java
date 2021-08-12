package com.slasher.slasherproductions.service.exception;

import com.slasher.slasherproductions.entiy.SongFK;

public class SongNotFoundException extends RuntimeException{

    public static SongNotFoundException of(SongFK idSong) {
        return new SongNotFoundException(idSong);
    }

    public SongNotFoundException(String message) {
        super(message);
    }

    private SongNotFoundException(SongFK idSong) {
        super(String.format("The song with id %d%d was not found",
                idSong.getIdAuthor(),
                idSong.getIdMusicalGroup()));
    }
}
