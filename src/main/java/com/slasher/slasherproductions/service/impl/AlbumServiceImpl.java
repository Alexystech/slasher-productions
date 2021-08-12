package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Album;
import com.slasher.slasherproductions.repository.AlbumRepository;
import com.slasher.slasherproductions.service.AlbumService;
import com.slasher.slasherproductions.service.exception.AlbumIsNullException;
import com.slasher.slasherproductions.service.exception.AlbumNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Album createAlbum(Album album) {

        if ( album == null ) {
            throw AlbumIsNullException.of();
        }

        return albumRepository.save(album);
    }

    @Override
    public void deleteAlbumById(long idAlbum) {

        if ( idAlbum < 1 ) {
            throw AlbumIsNullException.of();
        }

        Try.of( () -> getAlbumById(idAlbum) ).onFailure( (exception) -> {
            throw AlbumNotFoundException.of(idAlbum);
        });

        albumRepository.deleteById(idAlbum);
    }

    @Override
    public Album updateAlbum(Album album) {

        if ( album == null ) {
            throw AlbumIsNullException.of();
        }

        return albumRepository.save(album);
    }

    @Override
    public Album getAlbumById(long idAlbum) {
        return albumRepository.findById(idAlbum)
                .orElseThrow( () -> AlbumNotFoundException.of(idAlbum));
    }

    @Override
    public List<Album> getAllAlbums() {
        return ((List<Album>) albumRepository.findAll());
    }

    @Override
    public List<Album> getAlbumsByProducerHouse(long idProducerHouse) {
        return albumRepository.findAlbumsByProducerHouse(idProducerHouse).orElseThrow( () ->
                AlbumNotFoundException.of(idProducerHouse) );
    }

}
