package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Instrument;

import java.util.List;

public interface InstrumentService {
    Instrument createInstrument(Instrument instrument);
    void deleteInstrumentById(long id);
    Instrument updateInstrument(Instrument instrument);
    Instrument getInstrumentById(long idInstrument);
    List<Instrument> getAllInstruments();
}
