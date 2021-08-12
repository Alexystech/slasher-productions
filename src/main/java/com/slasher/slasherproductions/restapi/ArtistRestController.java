package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Artist;
import com.slasher.slasherproductions.service.ArtistService;
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
@RequestMapping(path = "/artist")
public class ArtistRestController {

    private final ArtistService artistService;

    @Autowired
    public ArtistRestController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.createArtist(artist), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idArtist}")
    public ResponseEntity<Boolean> deleteArtistById(@PathVariable("idArtist") long idArtist) {
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Artist> updateArtist(@RequestBody Artist artist) {
        return new ResponseEntity<>(artistService.updateArtist(artist), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idArtist}")
    public ResponseEntity<Artist> getArtistById(@PathVariable("idArtist") long idArtist) {
        return new ResponseEntity<>(artistService.getArtistById(idArtist), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Artist>> getAllArtist() {
        return new ResponseEntity<>(artistService.getAllArtist(), HttpStatus.OK);
    }

    @ApiResponses({
            @ApiResponse(code = 200, message = "successful"),
            @ApiResponse(code = 404, message = "insert a correct id, artists was not found"),
            @ApiResponse(code = 422, message = "Artist is null")
    })
    @GetMapping(path = "/get/artist/{idMusicalGroup}")
    public ResponseEntity<List<Artist>> getArtistsByMusicalGroup(@PathVariable("idMusicalGroup") long idMusicalGroup) {
        return new ResponseEntity<>(artistService.getArtistByMusicalGroup(idMusicalGroup), HttpStatus.OK);
    }

}
