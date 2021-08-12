package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.ProducerHouse;
import com.slasher.slasherproductions.service.ProducerHouseService;
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
@RequestMapping(path = "/producer-house")
public class ProducerHouseRestController {

    private final ProducerHouseService producerHouseService;

    @Autowired
    public ProducerHouseRestController(ProducerHouseService producerHouseService) {
        this.producerHouseService = producerHouseService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<ProducerHouse> createProducerHouse(@RequestBody ProducerHouse producerHouse) {
        return new ResponseEntity<>(producerHouseService.createProducerHouse(producerHouse), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idProducerHouse}")
    public ResponseEntity<Boolean> deleteProducerHouseById(@PathVariable("idProducerHouse") long idProducerHouse) {
        producerHouseService.deleteProducerHouseById(idProducerHouse);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<ProducerHouse> updateProducerHouse(@RequestBody ProducerHouse producerHouse) {
        return new ResponseEntity<>(producerHouseService.updateProducerHouse(producerHouse), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idProducerHouse}")
    public ResponseEntity<ProducerHouse> getProducerHouseById(@PathVariable("idProducerHouse") long idProducerHouse) {
        return new ResponseEntity<>(producerHouseService.getProducerHouseById(idProducerHouse), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<ProducerHouse>> getAllProducerHouses() {
        return new ResponseEntity<>(producerHouseService.getAllProducerHouses(), HttpStatus.OK);
    }

}
