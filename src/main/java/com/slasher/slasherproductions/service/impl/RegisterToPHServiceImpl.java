package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.RegisterToPH;
import com.slasher.slasherproductions.entiy.RegisterToPHFK;
import com.slasher.slasherproductions.repository.RegisterToPHRepository;
import com.slasher.slasherproductions.service.RegisterToPHService;
import com.slasher.slasherproductions.service.exception.RegisterToPHIsNullException;
import com.slasher.slasherproductions.service.exception.RegisterToPHNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterToPHServiceImpl implements RegisterToPHService {

    private final RegisterToPHRepository registerToPHRepository;

    @Autowired
    public RegisterToPHServiceImpl(RegisterToPHRepository registerToPHRepository) {
        this.registerToPHRepository = registerToPHRepository;
    }

    @Override
    public RegisterToPH createRegister(RegisterToPH registerToPH) {

        if ( registerToPH == null ) {
            throw RegisterToPHIsNullException.of();
        }

        return registerToPHRepository.save(registerToPH);
    }

    @Override
    public void deleteRegisterById(RegisterToPHFK registerToPHFK) {

        Try.of( () -> getRegisterById(registerToPHFK) ).onFailure( (exception) -> {
            throw RegisterToPHNotFoundException.of(registerToPHFK);
        });

        registerToPHRepository.deleteById(registerToPHFK);
    }

    @Override
    public RegisterToPH updateRegister(RegisterToPH registerToPH) {

        if ( registerToPH == null ) {
            throw RegisterToPHIsNullException.of();
        }

        return registerToPHRepository.save(registerToPH);
    }

    @Override
    public RegisterToPH getRegisterById(RegisterToPHFK registerToPHFK) {
        return registerToPHRepository.findById(registerToPHFK).orElseThrow( () -> {
            throw RegisterToPHNotFoundException.of(registerToPHFK);
        });
    }

    @Override
    public List<RegisterToPH> getAllRegisters() {
        return ((List<RegisterToPH>) registerToPHRepository.findAll());
    }
}
