package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.RegisterToPH;
import com.slasher.slasherproductions.entiy.RegisterToPHFK;

import java.util.List;

public interface RegisterToPHService {
    RegisterToPH createRegister(RegisterToPH registerToPH);
    void deleteRegisterById(RegisterToPHFK registerToPHFK);
    RegisterToPH updateRegister(RegisterToPH registerToPH);
    RegisterToPH getRegisterById(RegisterToPHFK registerToPHFK);
    List<RegisterToPH> getAllRegisters();
}
