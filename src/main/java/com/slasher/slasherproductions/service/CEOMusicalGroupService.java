package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.CEOMusicalGroup;

import java.util.List;

public interface CEOMusicalGroupService {
    CEOMusicalGroup createCEO(CEOMusicalGroup ceoMusicalGroup);
    void deleteCEOById(long idCEO);
    CEOMusicalGroup updateCEO(CEOMusicalGroup ceoMusicalGroup);
    CEOMusicalGroup getCEOById(long idCEO);
    List<CEOMusicalGroup> getAllCEOS();
}
