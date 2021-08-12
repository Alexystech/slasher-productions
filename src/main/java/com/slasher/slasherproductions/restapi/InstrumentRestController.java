package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Instrument;
import com.slasher.slasherproductions.service.InstrumentService;
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
@RequestMapping(path = "/instrument")
public class InstrumentRestController {

    private final InstrumentService instrumentService;

    @Autowired
    public InstrumentRestController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Instrument> createInstrument(@RequestBody Instrument instrument) {

        if ( instrument == null ) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(instrumentService.createInstrument(instrument), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idInstrument}")
    public ResponseEntity<Boolean> deleteInstrumentById(@PathVariable("idInstrument") long idInstrument) {
        instrumentService.deleteInstrumentById(idInstrument);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocesable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Instrument> updateInstrument(@RequestBody Instrument instrument) {

        if ( instrument == null ) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<>(instrumentService.updateInstrument(instrument), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idInstrument}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable("idInstrument") long idInstrument) {
        return new ResponseEntity<>(instrumentService.getInstrumentById(idInstrument), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Instrument>> getAllInstruments() {
        return new ResponseEntity<>(instrumentService.getAllInstruments(), HttpStatus.OK);
    }

}
