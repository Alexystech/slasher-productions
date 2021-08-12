package com.slasher.slasherproductions.service.exception;

public class MusicalGroupNotFoundException extends RuntimeException {

    public static MusicalGroupNotFoundException of(long idMusicalGroup) {
        return new MusicalGroupNotFoundException(idMusicalGroup);
    }

    public MusicalGroupNotFoundException(String message) {
        super(message);
    }

    private MusicalGroupNotFoundException(long idMusicalGroup) {
        super(String.format("musical group with id %d was not found",
                idMusicalGroup));
    }
}
