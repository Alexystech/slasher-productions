package com.slasher.slasherproductions.service.exception;

public class AdministratorNotFoundException extends RuntimeException {

    public static AdministratorNotFoundException of(long idAdministrator) {
        return new AdministratorNotFoundException(idAdministrator);
    }

    public AdministratorNotFoundException(String message) {
        super(message);
    }

    private AdministratorNotFoundException(long idAdministrator) {
        super(String.format("Administrator with id %d was not found",
                idAdministrator));
    }
}
