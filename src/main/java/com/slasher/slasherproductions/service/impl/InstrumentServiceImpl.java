package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Instrument;
import com.slasher.slasherproductions.repository.InstrumentRepository;
import com.slasher.slasherproductions.service.InstrumentService;
import com.slasher.slasherproductions.service.exception.InstrumentIsNullException;
import com.slasher.slasherproductions.service.exception.InstrumentNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    private final InstrumentRepository instrumentRepository;

    @Autowired
    public InstrumentServiceImpl(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    @Override
    public Instrument createInstrument(Instrument instrument) {

        if ( instrument == null ) {
            throw InstrumentIsNullException.of();
        }

        return instrumentRepository.save(instrument);
    }

    @Override
    public void deleteInstrumentById(long id) {

        if ( id < 1 ) {
            throw InstrumentIsNullException.of();
        }

        Try.of( () -> getInstrumentById(id) ).onFailure( (exception) -> {
            throw InstrumentNotFoundException.of(id);
        });

        instrumentRepository.deleteById(id);
    }

    @Override
    public Instrument updateInstrument(Instrument instrument) {

        if ( instrument == null ) {
            throw InstrumentIsNullException.of();
        }

        return instrumentRepository.save(instrument);
    }

    @Override
    public Instrument getInstrumentById(long idInstrument) {
        return instrumentRepository.findById(idInstrument)
                .orElseThrow( () -> InstrumentNotFoundException.of(idInstrument));
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return ((List<Instrument>) instrumentRepository.findAll());
    }
}
