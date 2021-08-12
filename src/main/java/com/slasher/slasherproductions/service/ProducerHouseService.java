package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.ProducerHouse;

import java.util.List;

public interface ProducerHouseService {
    ProducerHouse createProducerHouse(ProducerHouse producerHouse);
    void deleteProducerHouseById(long idProducerHouse);
    ProducerHouse updateProducerHouse(ProducerHouse producerHouse);
    ProducerHouse getProducerHouseById(long idProducerHouse);
    List<ProducerHouse> getAllProducerHouses();
}
