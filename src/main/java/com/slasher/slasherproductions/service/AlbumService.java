package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Album;

import java.util.List;

public interface AlbumService {
    Album createAlbum(Album album);
    void deleteAlbumById(long idAlbum);
    Album updateAlbum(Album album);
    Album getAlbumById(long idAlbum);
    List<Album> getAllAlbums();
    List<Album> getAlbumsByProducerHouse(long idProducerHouse);
}
