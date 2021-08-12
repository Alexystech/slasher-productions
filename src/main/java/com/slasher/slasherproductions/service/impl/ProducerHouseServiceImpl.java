package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.ProducerHouse;
import com.slasher.slasherproductions.repository.ProducerHouseRepository;
import com.slasher.slasherproductions.service.ProducerHouseService;
import com.slasher.slasherproductions.service.exception.ProducerHouseIsNullException;
import com.slasher.slasherproductions.service.exception.ProducerHouseNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerHouseServiceImpl implements ProducerHouseService {

    private final ProducerHouseRepository producerHouseRepository;

    @Autowired
    public ProducerHouseServiceImpl(ProducerHouseRepository producerHouseRepository) {
        this.producerHouseRepository = producerHouseRepository;
    }

    @Override
    public ProducerHouse createProducerHouse(ProducerHouse producerHouse) {

        if ( producerHouse == null ) {
            throw ProducerHouseIsNullException.of();
        }

        return producerHouseRepository.save(producerHouse);
    }

    @Override
    public void deleteProducerHouseById(long idProducerHouse) {

        if ( idProducerHouse < 1 ) {
            throw ProducerHouseIsNullException.of();
        }

        Try.of( () -> getProducerHouseById(idProducerHouse) ).onFailure( (exception) -> {
            throw ProducerHouseNotFoundException.of(idProducerHouse);
        });

        producerHouseRepository.deleteById(idProducerHouse);
    }

    @Override
    public ProducerHouse updateProducerHouse(ProducerHouse producerHouse) {

        if ( producerHouse == null ) {
            throw ProducerHouseIsNullException.of();
        }

        return producerHouseRepository.save(producerHouse);
    }

    @Override
    public ProducerHouse getProducerHouseById(long idProducerHouse) {
        return producerHouseRepository.findById(idProducerHouse).orElseThrow( () -> {
            throw ProducerHouseNotFoundException.of(idProducerHouse);
        });
    }

    @Override
    public List<ProducerHouse> getAllProducerHouses() {
        return ((List<ProducerHouse>) producerHouseRepository.findAll());
    }
}
