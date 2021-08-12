package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
