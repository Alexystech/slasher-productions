package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Artist;
import com.slasher.slasherproductions.repository.ArtistRepository;
import com.slasher.slasherproductions.service.ArtistService;
import com.slasher.slasherproductions.service.exception.ArtistIsNullException;
import com.slasher.slasherproductions.service.exception.ArtistNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Artist createArtist(Artist artist) {

        if ( artist == null ) {
            throw ArtistIsNullException.of();
        }

        return artistRepository.save(artist);
    }

    @Override
    public void deleteArtistById(long idArtist) {

        if ( idArtist < 1 ) {
            throw ArtistIsNullException.of();
        }

        Try.of( () -> getArtistById(idArtist) ).onFailure( (exception) -> {
            throw ArtistNotFoundException.of(idArtist);
        });

        artistRepository.deleteById(idArtist);
    }

    @Override
    public Artist updateArtist(Artist artist) {

        if ( artist == null ) {
            throw ArtistIsNullException.of();
        }

        return artistRepository.save(artist);
    }

    @Override
    public Artist getArtistById(long idArtist) {
        return artistRepository.findById(idArtist).orElseThrow( () -> {
            throw ArtistNotFoundException.of(idArtist);
        });
    }

    @Override
    public List<Artist> getAllArtist() {
        return ((List<Artist>) artistRepository.findAll());
    }

    @Override
    public List<Artist> getArtistByMusicalGroup(long idMusicalGroup) {

        if ( idMusicalGroup < 1 ) {
            throw ArtistIsNullException.of();
        }

        return artistRepository.findArtistByMusicalGroup(idMusicalGroup).orElseThrow( () -> {
            throw new ArtistNotFoundException("insert a correct id, artists was not found");
        });
    }

}
