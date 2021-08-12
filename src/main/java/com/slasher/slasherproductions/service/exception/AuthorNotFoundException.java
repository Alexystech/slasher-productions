package com.slasher.slasherproductions.service.exception;

public class AuthorNotFoundException extends RuntimeException{

    public static AuthorNotFoundException of(long idAuthor) {
        return new AuthorNotFoundException(idAuthor);
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }

    private AuthorNotFoundException(long idAuthor) {
        super(String.format("Author with id %d was not found",
                idAuthor));
    }

}
