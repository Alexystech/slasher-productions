package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Administrator;

import java.util.List;

public interface AdministratorService {
    Administrator createAdministrator(Administrator administrator);
    void deleteAdministratorById(long idAdministrator);
    Administrator updateAdministrator(Administrator administrator);
    Administrator getAdministratorById(long idAdministrator);
    List<Administrator> getAllAdministrators();
}
