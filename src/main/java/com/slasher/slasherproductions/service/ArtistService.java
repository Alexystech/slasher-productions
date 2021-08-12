package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Artist;

import java.util.List;

public interface ArtistService {
    Artist createArtist(Artist artist);
    void deleteArtistById(long idArtist);
    Artist updateArtist(Artist artist);
    Artist getArtistById(long idArtist);
    List<Artist> getAllArtist();
    List<Artist> getArtistByMusicalGroup(long idMusicalGroup);
}
