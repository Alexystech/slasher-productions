package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Administrator;
import com.slasher.slasherproductions.repository.AdministratorRepository;
import com.slasher.slasherproductions.service.AdministratorService;
import com.slasher.slasherproductions.service.exception.AdministratorIsNullException;
import com.slasher.slasherproductions.service.exception.AdministratorNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public Administrator createAdministrator(Administrator administrator) {

        if ( administrator == null ) {
            throw AdministratorIsNullException.of();
        }

        return administratorRepository.save(administrator);
    }

    @Override
    public void deleteAdministratorById(long idAdministrator) {

        if ( idAdministrator < 1 ) {
            throw AdministratorIsNullException.of();
        }

        Try.of( () -> getAdministratorById(idAdministrator) ).onFailure( (exception) -> {
            throw AdministratorNotFoundException.of(idAdministrator);
        });

        administratorRepository.deleteById(idAdministrator);
    }

    @Override
    public Administrator updateAdministrator(Administrator administrator) {

        if ( administrator == null ) {
            throw AdministratorIsNullException.of();
        }

        return administratorRepository.save(administrator);
    }

    @Override
    public Administrator getAdministratorById(long idAdministrator) {
        return administratorRepository.findById(idAdministrator)
                .orElseThrow(() -> AdministratorNotFoundException.of(idAdministrator));
    }

    @Override
    public List<Administrator> getAllAdministrators() {
        return ((List<Administrator>) administratorRepository.findAll());
    }
}
