package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    void deleteAuthorById(long idAuthor);
    Author updateAuthor(Author author);
    Author getAuthorById(long idAuthor);
    List<Author> getAllAuthors();
}
