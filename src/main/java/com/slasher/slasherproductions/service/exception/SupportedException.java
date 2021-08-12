package com.slasher.slasherproductions.service.exception;

import org.springframework.http.HttpStatus;

public enum SupportedException {

    ADMINISTRATOR_IS_NULL(AdministratorIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    ADMINISTRATOR_NOT_FOUND(AdministratorNotFoundException.class, HttpStatus.NOT_FOUND),
    ALBUM_IS_NULL(AlbumIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    ALBUM_NOT_FOUND(AlbumNotFoundException.class, HttpStatus.NOT_FOUND),
    ARTIST_IS_NULL(ArtistIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    ARTIST_NOT_FOUND(ArtistNotFoundException.class, HttpStatus.NOT_FOUND),
    AUTHOR_IS_NULL(AuthorIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    AUTHOR_NOT_FOUND(AuthorNotFoundException.class, HttpStatus.NOT_FOUND),
    CEO_IS_NULL(CEOIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    CEO_NOT_FOUND(CEONotFoundException.class, HttpStatus.NOT_FOUND),
    INSTRUMENT_IS_NULL(InstrumentIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    INSTRUMENT_NOT_FOUND(InstrumentNotFoundException.class, HttpStatus.NOT_FOUND),
    MUSICAL_GROUP_IS_NULL(MusicalGroupIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    MUSICAL_GROUP_NOT_FOUND(MusicalGroupNotFoundException.class, HttpStatus.NOT_FOUND),
    PRODUCER_HOUSE_IS_NULL(ProducerHouseIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    PRODUCER_HOUSE_NOT_FOUND(ProducerHouseNotFoundException.class, HttpStatus.NOT_FOUND),
    REGISTER_TO_PH_IS_NULL(RegisterToPHIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    REGISTER_TO_PH_NOT_FOUND(RegisterToPHNotFoundException.class, HttpStatus.NOT_FOUND),
    SONG_BY_ALBUM_NOT_FOUND(SongByAlbumNotFoundException.class, HttpStatus.NOT_FOUND),
    SONG_BY_AUTHOR_NOT_FOUND(SongByAuthorNotFoundException.class, HttpStatus.NOT_FOUND),
    SONG_IS_NULL(SongIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    SONG_NOT_FOUND(SongNotFoundException.class, HttpStatus.NOT_FOUND),
    USER_IS_NULL(UserIsNullException.class, HttpStatus.UNPROCESSABLE_ENTITY),
    USER_NOT_FOUND(UserNotFoundException.class, HttpStatus.NOT_FOUND);

    private final Class<? extends Throwable> exceptionClass;
    private final HttpStatus status;

    SupportedException(Class<? extends Throwable> exceptionClass, HttpStatus status) {
        this.exceptionClass = exceptionClass;
        this.status = status;
    }

    public Class<? extends Throwable> getExceptionClass() {
        return exceptionClass;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
