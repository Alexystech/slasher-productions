package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.CEOMusicalGroup;
import com.slasher.slasherproductions.repository.CEOMusicalGroupRepository;
import com.slasher.slasherproductions.service.CEOMusicalGroupService;
import com.slasher.slasherproductions.service.exception.CEOIsNullException;
import com.slasher.slasherproductions.service.exception.CEONotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CEOMusicalGroupServiceImpl implements CEOMusicalGroupService {

    private CEOMusicalGroupRepository ceoRepository;

    @Autowired
    public CEOMusicalGroupServiceImpl(CEOMusicalGroupRepository ceoRepository) {
        this.ceoRepository = ceoRepository;
    }

    @Override
    public CEOMusicalGroup createCEO(CEOMusicalGroup ceoMusicalGroup) {

        if ( ceoMusicalGroup == null ) {
            throw CEOIsNullException.of();
        }

        return ceoRepository.save(ceoMusicalGroup);
    }

    @Override
    public void deleteCEOById(long idCEO) {

        if ( idCEO < 0 ) {
            throw CEOIsNullException.of();
        }

        Try.of( () -> getCEOById(idCEO) ).onFailure( (exception) -> {
            throw CEONotFoundException.of(idCEO);
        });

        ceoRepository.deleteById(idCEO);
    }

    @Override
    public CEOMusicalGroup updateCEO(CEOMusicalGroup ceoMusicalGroup) {

        if ( ceoMusicalGroup == null ) {
            throw CEOIsNullException.of();
        }

        return ceoRepository.save(ceoMusicalGroup);
    }

    @Override
    public CEOMusicalGroup getCEOById(long idCEO) {
        return ceoRepository.findById(idCEO)
                .orElseThrow( () -> CEONotFoundException.of(idCEO));
    }

    @Override
    public List<CEOMusicalGroup> getAllCEOS() {
        return ((List<CEOMusicalGroup>) ceoRepository.findAll());
    }
}
