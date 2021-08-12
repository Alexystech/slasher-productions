package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.RegisterToPH;
import com.slasher.slasherproductions.entiy.RegisterToPHFK;
import com.slasher.slasherproductions.service.RegisterToPHService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/register-to-ph")
public class RegisterToPHRestController {

    private final RegisterToPHService registerService;

    @Autowired
    public RegisterToPHRestController(RegisterToPHService registerService) {
        this.registerService = registerService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<RegisterToPH> createRegisterToPH(@RequestBody RegisterToPH registerToPH) {
        return new ResponseEntity<>(registerService.createRegister(registerToPH), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idRegisterToPH}")
    public ResponseEntity<Boolean> deleteRegisterToPHByid(@PathVariable("idRegisterToPH") RegisterToPHFK idRegisterToPH) {
        registerService.deleteRegisterById(idRegisterToPH);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<RegisterToPH> updateRegisterToPH(@RequestBody RegisterToPH registerToPH) {
        return new ResponseEntity<>(registerService.updateRegister(registerToPH), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idRegisterToPH}")
    public ResponseEntity<RegisterToPH> getRegisterToPHById(@PathVariable("idRegisterToPh") RegisterToPHFK idRegisterToPH) {
        return new ResponseEntity<>(registerService.getRegisterById(idRegisterToPH), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping
    public ResponseEntity<List<RegisterToPH>> getAllRegistersToPH() {
        return new ResponseEntity<>(registerService.getAllRegisters(), HttpStatus.OK);
    }

}
