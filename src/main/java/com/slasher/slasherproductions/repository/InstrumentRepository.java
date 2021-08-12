package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Instrument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends CrudRepository<Instrument, Long> {
}
