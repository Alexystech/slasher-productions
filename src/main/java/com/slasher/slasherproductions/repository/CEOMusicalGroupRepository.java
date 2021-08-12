package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.CEOMusicalGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CEOMusicalGroupRepository extends CrudRepository<CEOMusicalGroup, Long> {
}
