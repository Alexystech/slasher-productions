package com.slasher.slasherproductions.service.exception;

import com.slasher.slasherproductions.entiy.RegisterToPHFK;

public class RegisterToPHNotFoundException extends RuntimeException {

    public static RegisterToPHNotFoundException of(RegisterToPHFK registerToPHFK) {
        return new RegisterToPHNotFoundException(registerToPHFK);
    }

    public RegisterToPHNotFoundException(String message) {
        super(message);
    }

    private RegisterToPHNotFoundException(RegisterToPHFK registerToPHFK) {
        super(String.format("Register with id %d%d was not found",
                registerToPHFK.getIdCEO(),
                registerToPHFK.getIdProducerHouse()));
    }
}
