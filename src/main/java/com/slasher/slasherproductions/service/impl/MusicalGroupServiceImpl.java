package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.MusicalGroup;
import com.slasher.slasherproductions.repository.MusicalGroupRepository;
import com.slasher.slasherproductions.service.MusicalGroupService;
import com.slasher.slasherproductions.service.exception.MusicalGroupIsNullException;
import com.slasher.slasherproductions.service.exception.MusicalGroupNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicalGroupServiceImpl implements MusicalGroupService {

    private final MusicalGroupRepository musicalGroupRepository;

    @Autowired
    public MusicalGroupServiceImpl(MusicalGroupRepository musicalGroupRepository) {
        this.musicalGroupRepository = musicalGroupRepository;
    }

    @Override
    public MusicalGroup createMusicalGroup(MusicalGroup musicalGroup) {

        if ( musicalGroup == null ) {
            throw MusicalGroupIsNullException.of();
        }

        return musicalGroupRepository.save(musicalGroup);
    }

    @Override
    public void deleteMusicalGroup(long idMusicalGroup) {

        if ( idMusicalGroup < 1 ) {
            throw MusicalGroupIsNullException.of();
        }

        Try.of( () -> getMusicalGroupById(idMusicalGroup) ).onFailure( (exception) -> {
            throw MusicalGroupNotFoundException.of(idMusicalGroup);
        });

        musicalGroupRepository.deleteById(idMusicalGroup);
    }

    @Override
    public MusicalGroup updateMusicalGroup(MusicalGroup musicalGroup) {

        if ( musicalGroup == null ) {
            throw MusicalGroupIsNullException.of();
        }

        return musicalGroupRepository.save(musicalGroup);
    }

    @Override
    public MusicalGroup getMusicalGroupById(long idMusicalGroup) {
        return musicalGroupRepository.findById(idMusicalGroup).orElseThrow( () -> {
            throw MusicalGroupNotFoundException.of(idMusicalGroup);
        });
    }

    @Override
    public List<MusicalGroup> getAllMusicalGroups() {
        return ((List<MusicalGroup>) musicalGroupRepository.findAll());
    }
}
