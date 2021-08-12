package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.MusicalGroup;
import com.slasher.slasherproductions.service.MusicalGroupService;
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
@RequestMapping(path = "/musical-group")
public class MusicalGroupRestController {

    private final MusicalGroupService musicalGroupService;

    @Autowired
    public MusicalGroupRestController(MusicalGroupService musicalGroupService) {
        this.musicalGroupService = musicalGroupService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<MusicalGroup> createMusicalGroup(@RequestBody MusicalGroup musicalGroup) {
        return new ResponseEntity<>(musicalGroupService.createMusicalGroup(musicalGroup), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idMusicalGroup}")
    public ResponseEntity<Boolean> deleteMusicalGroup(@PathVariable("/idMusicalGroup") long idMusicalGroup) {
        musicalGroupService.deleteMusicalGroup(idMusicalGroup);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<MusicalGroup> updateMusicalGroup(@RequestBody MusicalGroup musicalGroup) {
        return new ResponseEntity<>(musicalGroupService.updateMusicalGroup(musicalGroup), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idMusicalGroup}")
    public ResponseEntity<MusicalGroup> getMusicalGroupById(@PathVariable("idMusicalGroup") long idMuscialGroup) {
        return new ResponseEntity<>(musicalGroupService.getMusicalGroupById(idMuscialGroup), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<MusicalGroup>> getAllMusicalGroup() {
        return new ResponseEntity<>(musicalGroupService.getAllMusicalGroups(), HttpStatus.OK);
    }

}
