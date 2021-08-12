package com.slasher.slasherproductions.restapi;

import com.slasher.slasherproductions.entiy.Author;
import com.slasher.slasherproductions.service.AuthorService;
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
@RequestMapping(path = "/author")
public class AuthorRestController {

    private final AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ApiResponses({
            @ApiResponse(code = 422, message = "unprocessable entity"),
            @ApiResponse(code = 201, message = "created")
    })
    @PostMapping(path = "/create")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);
    }

    @ApiResponse(code = 202, message = "successful")
    @DeleteMapping(path = "/delete/{idAuthor}")
    public ResponseEntity<Boolean> deleteAuthorById(@PathVariable("idAuthor") long idAuthor) {
        authorService.deleteAuthorById(idAuthor);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 202, message = "updated")
    @PutMapping(path = "/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.ACCEPTED);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping("/get/{idAuthor}")
    public ResponseEntity<Author> getAthorById(@PathVariable("idAuthor") long idAuthor) {
        return new ResponseEntity<>(authorService.getAuthorById(idAuthor), HttpStatus.OK);
    }

    @ApiResponse(code = 200, message = "successful")
    @GetMapping(path = "/get/all")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

}
