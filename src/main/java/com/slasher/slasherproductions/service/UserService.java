package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    void deleteUserById(long idUser);
    User updateUser(User user);
    User getUserById(long idUser);
    List<User> getAllUsers();
}
