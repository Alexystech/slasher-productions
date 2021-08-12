package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.CEOMusicalGroup;
import com.slasher.slasherproductions.service.CEOMusicalGroupService;
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
@RequestMapping(path = "/ceo-musical-group")
public class CEOMusicalGroupRestController {

    private final CEOMusicalGroupService ceoService;

    @Autowired
    public CEOMusicalGroupRestController(CEOMusicalGroupService ceoService) {
        this.ceoService = ceoService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping("/create")
    public ResponseEntity<CEOMusicalGroup> createCEO(@RequestBody CEOMusicalGroup ceo) {
        return new ResponseEntity<>(ceoService.createCEO(ceo), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idCEO}")
    public ResponseEntity<Boolean> deleteCEOById(@PathVariable("idCEO") long idCEO) {
        ceoService.deleteCEOById(idCEO);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<CEOMusicalGroup> updateCEO(@RequestBody CEOMusicalGroup ceo) {
        return new ResponseEntity<>(ceoService.updateCEO(ceo), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idCEO}")
    public ResponseEntity<CEOMusicalGroup> getCEOById(@PathVariable("idCEO") long idCEO) {
        return new ResponseEntity<>(ceoService.getCEOById(idCEO), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<CEOMusicalGroup>> getAllCEOs() {
        return new ResponseEntity<>(ceoService.getAllCEOS(), HttpStatus.OK);
    }

}
