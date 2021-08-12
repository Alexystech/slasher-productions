package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.RegisterToPH;
import com.slasher.slasherproductions.entiy.RegisterToPHFK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterToPHRepository extends CrudRepository<RegisterToPH, RegisterToPHFK> {
}
