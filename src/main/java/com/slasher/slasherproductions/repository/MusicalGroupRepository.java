package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.MusicalGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicalGroupRepository extends CrudRepository<MusicalGroup, Long> {
}
