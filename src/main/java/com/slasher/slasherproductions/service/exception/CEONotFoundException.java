package com.slasher.slasherproductions.service.exception;

public class CEONotFoundException extends RuntimeException{

    public static CEONotFoundException of(long idCEO){
        return new CEONotFoundException(idCEO);
    }

    public CEONotFoundException(String message) {
        super(message);
    }

    private CEONotFoundException(long idCEO) {
        super(String.format("CEO with id %d was not found",
                idCEO));
    }

}
