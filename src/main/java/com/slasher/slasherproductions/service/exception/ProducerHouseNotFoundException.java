package com.slasher.slasherproductions.service.exception;

public class ProducerHouseNotFoundException extends RuntimeException{

    public static ProducerHouseNotFoundException of(long idProducerHouse) {
        return new ProducerHouseNotFoundException(idProducerHouse);
    }

    public ProducerHouseNotFoundException(String message) {
        super(message);
    }

    private ProducerHouseNotFoundException(long idProducerHouse) {
        super(String.format("Producer house with id %d was not found",
                idProducerHouse));
    }

}
