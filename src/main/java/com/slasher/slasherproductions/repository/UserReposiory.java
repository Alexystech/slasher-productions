package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposiory extends CrudRepository<User, Long> {
}
