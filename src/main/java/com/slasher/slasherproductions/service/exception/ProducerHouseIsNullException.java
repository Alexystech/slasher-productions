package com.slasher.slasherproductions.service.exception;

public class ProducerHouseIsNullException extends RuntimeException {

    public static ProducerHouseIsNullException of() {
        return new ProducerHouseIsNullException();
    }

    public ProducerHouseIsNullException(String message) {
        super(message);
    }

    private ProducerHouseIsNullException() {
        super("producer house is null");
    }

}
