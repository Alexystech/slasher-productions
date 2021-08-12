package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Song;
import com.slasher.slasherproductions.entiy.SongFK;
import com.slasher.slasherproductions.service.SongService;
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
@RequestMapping(path = "/song")
public class SongRestController {

    private final SongService songService;

    @Autowired
    public SongRestController(SongService songService) {
        this.songService = songService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
       return new ResponseEntity<>(songService.createSong(song), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idSong}")
    public ResponseEntity<Boolean> deleteSongById(@PathVariable("idSong") SongFK idSong) {
        songService.deleteSongById(idSong);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 202, message = "updated")
    })
    @PutMapping(path = "/update")
    public ResponseEntity<Song> updateSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.updateSong(song), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/{idSong}")
    public ResponseEntity<Song> getSongById(@PathVariable("idSong") SongFK idSong) {
        return new ResponseEntity<>(songService.getSongById(idSong), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Song>> getAllSongs() {
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/songs/{idAlbum}")
    public ResponseEntity<List<Song>> getSongsByAlbum(@PathVariable("idAlbum") long idAlbum) {
        return new ResponseEntity<>(songService.getSongsByAlbum(idAlbum), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/songs/{idAuthor}")
    public ResponseEntity<List<Song>> getSongByAuthor(@PathVariable("idAuthor") long idAuthor) {
        return new ResponseEntity<>(songService.getSongsByAuthor(idAuthor), HttpStatus.OK);
    }

}
