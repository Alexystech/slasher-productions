package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Album;
import com.slasher.slasherproductions.service.AlbumService;
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
@RequestMapping(path = "/album")
public class AlbumRestController {

    private final AlbumService albumService;

    @Autowired
    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.createAlbum(album), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idAlbum}")
    public ResponseEntity<Boolean> deleteAlbumById(@PathVariable(value = "idAlbum") long idAlbum) {
        albumService.deleteAlbumById(idAlbum);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.updateAlbum(album), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "success")
    @GetMapping(path = "/get/{idAlbum}")
    public ResponseEntity<Album> getAlbumById(@PathVariable(value = "idAlbum") long idAlbum) {
        Album album = albumService.getAlbumById(idAlbum);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "success")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "success")
    @GetMapping(path = "/get/album/by/{idProducerHouse}")
    public ResponseEntity<List<Album>> getAlbumsByProducerHouse(@PathVariable("idProducerHouse") long idProducerHouse) {
        return new ResponseEntity<>(albumService.getAlbumsByProducerHouse(idProducerHouse), HttpStatus.OK);
    }
}
