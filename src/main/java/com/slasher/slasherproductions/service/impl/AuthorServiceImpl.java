package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Author;
import com.slasher.slasherproductions.repository.AuthorRepository;
import com.slasher.slasherproductions.service.AuthorService;
import com.slasher.slasherproductions.service.exception.AuthorIsNullException;
import com.slasher.slasherproductions.service.exception.AuthorNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {

        if ( author == null ) {
            throw AuthorIsNullException.of();
        }

        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthorById(long idAuthor) {

        if ( idAuthor < 1 ) {
            throw AuthorIsNullException.of();
        }

        Try.of( () -> getAuthorById(idAuthor) ).onFailure( (exception) -> {
            throw AuthorNotFoundException.of(idAuthor);
        });

        authorRepository.deleteById(idAuthor);
    }

    @Override
    public Author updateAuthor(Author author) {

        if ( author == null ) {
            throw AuthorIsNullException.of();
        }

        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(long idAuthor) {
        return authorRepository.findById(idAuthor)
                .orElseThrow( () -> AuthorNotFoundException.of(idAuthor));
    }

    @Override
    public List<Author> getAllAuthors() {
        return ((List<Author>) authorRepository.findAll());
    }
}
