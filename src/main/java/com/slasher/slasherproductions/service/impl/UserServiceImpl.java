package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.User;
import com.slasher.slasherproductions.repository.UserReposiory;
import com.slasher.slasherproductions.service.UserService;
import com.slasher.slasherproductions.service.exception.UserIsNullException;
import com.slasher.slasherproductions.service.exception.UserNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserReposiory userReposiory;

    @Autowired
    public UserServiceImpl(UserReposiory userReposiory) {
        this.userReposiory = userReposiory;
    }

    @Override
    public User createUser(User user) {

        if ( user == null ) {
            throw UserIsNullException.of();
        }

        return userReposiory.save(user);
    }

    @Override
    public void deleteUserById(long idUser) {

        if ( idUser < 1 ) {
            throw UserIsNullException.of();
        }

        Try.of( () -> getUserById(idUser) ).onFailure( (exception) -> {
            throw UserNotFoundException.of(idUser);
        });

        userReposiory.deleteById(idUser);
    }

    @Override
    public User updateUser(User user) {

        if ( user == null ) {
            throw UserIsNullException.of();
        }

        return userReposiory.save(user);
    }

    @Override
    public User getUserById(long idUser) {
        return userReposiory.findById(idUser).orElseThrow( () -> {
            throw UserNotFoundException.of(idUser);
        });
    }

    @Override
    public List<User> getAllUsers() {
        return ((List<User>) userReposiory.findAll());
    }
}
