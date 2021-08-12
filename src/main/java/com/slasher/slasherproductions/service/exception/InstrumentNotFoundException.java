package com.slasher.slasherproductions.service.exception;

public class InstrumentNotFoundException extends RuntimeException{

    public static InstrumentNotFoundException of(long idInstrument) {
        return new InstrumentNotFoundException(idInstrument);
    }

    public InstrumentNotFoundException(String message) {
        super(message);
    }

    private InstrumentNotFoundException(long idInstrument) {
        super(String.format("Instrument with id %d was not found",
                idInstrument));
    }

}
