package com.slasher.slasherproductions.service.exception;

public class RegisterToPHIsNullException extends RuntimeException{

    public static RegisterToPHIsNullException of() {
        return new RegisterToPHIsNullException();
    }

    public RegisterToPHIsNullException(String message) {
        super(message);
    }

    private RegisterToPHIsNullException() {
        super("The register is null");
    }
}
