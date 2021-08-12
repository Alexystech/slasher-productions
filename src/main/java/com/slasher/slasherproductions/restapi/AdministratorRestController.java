package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Administrator;
import com.slasher.slasherproductions.service.AdministratorService;
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
@RequestMapping(path = "/administrator")
public class AdministratorRestController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorRestController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        return new ResponseEntity<>(administratorService.createAdministrator(administrator), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idAdministrator}")
    public ResponseEntity<Boolean> deleteAdministratorById(@PathVariable(value = "idAdministrator") long idAdministrator) {
        administratorService.deleteAdministratorById(idAdministrator);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator) {
        return new ResponseEntity<>(administratorService.updateAdministrator(administrator),
                HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "administrator was not found")
    })
    @GetMapping(path = "/get/{idAdministrator}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable(value = "idAdministrator") long idAdministrator) {
        Administrator administrator = administratorService.getAdministratorById(idAdministrator);
        return new ResponseEntity<>(administrator, HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        return new ResponseEntity<>(administratorService.getAllAdministrators(), HttpStatus.OK);
    }

}
