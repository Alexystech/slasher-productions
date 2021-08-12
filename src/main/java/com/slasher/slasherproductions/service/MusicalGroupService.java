package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.MusicalGroup;

import java.util.List;

public interface MusicalGroupService {
    MusicalGroup createMusicalGroup(MusicalGroup musicalGroup);
    void deleteMusicalGroup(long idMusicalGroup);
    MusicalGroup updateMusicalGroup(MusicalGroup musicalGroup);
    MusicalGroup getMusicalGroupById(long idMusicalGroup);
    List<MusicalGroup> getAllMusicalGroups();
}
