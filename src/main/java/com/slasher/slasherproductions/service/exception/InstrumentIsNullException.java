package com.slasher.slasherproductions.service.exception;

public class InstrumentIsNullException extends RuntimeException{

    public static InstrumentIsNullException of() {
        return new InstrumentIsNullException();
    }

    public InstrumentIsNullException(String message) {
        super(message);
    }

    private InstrumentIsNullException() {
        super("Instrument is null");
    }
}
