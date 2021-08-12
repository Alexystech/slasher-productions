package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.ProducerHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerHouseRepository extends CrudRepository<ProducerHouse, Long> {
}
