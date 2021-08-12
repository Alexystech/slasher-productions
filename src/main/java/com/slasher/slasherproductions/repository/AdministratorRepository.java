package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}
