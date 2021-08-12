package com.slasher.slasherproductions.service.impl;

import com.slasher.slasherproductions.entiy.Song;
import com.slasher.slasherproductions.entiy.SongFK;
import com.slasher.slasherproductions.repository.SongRepository;
import com.slasher.slasherproductions.service.SongService;
import com.slasher.slasherproductions.service.exception.SongByAlbumNotFoundException;
import com.slasher.slasherproductions.service.exception.SongByAuthorNotFoundException;
import com.slasher.slasherproductions.service.exception.SongIsNullException;
import com.slasher.slasherproductions.service.exception.SongNotFoundException;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song createSong(Song song) {

        if ( song == null ) {
            throw SongIsNullException.of();
        }

        return songRepository.save(song);
    }

    @Override
    public void deleteSongById(SongFK songFK) {

        Try.of( () -> getSongById(songFK) ).onFailure( (exception) -> {
            throw SongNotFoundException.of(songFK);
        });

        songRepository.deleteById(songFK);
    }

    @Override
    public Song updateSong(Song song) {

        if ( song == null ) {
            throw SongIsNullException.of();
        }

        return songRepository.save(song);
    }

    @Override
    public Song getSongById(SongFK songFK) {
        return songRepository.findById(songFK).orElseThrow( () -> {
            throw SongNotFoundException.of(songFK);
        });
    }

    @Override
    public List<Song> getAllSongs() {
        return ((List<Song>) songRepository.findAll());
    }

    @Override
    public List<Song> getSongsByAlbum(long idAlbum) {
        return songRepository.findSongsByAlbum(idAlbum).orElseThrow( () -> {
            throw SongByAlbumNotFoundException.of(idAlbum);
        });
    }

    @Override
    public List<Song> getSongsByAuthor(long idAuthor) {
        return songRepository.findSongsByAuthor(idAuthor).orElseThrow( () -> {
            throw SongByAuthorNotFoundException.of(idAuthor);
        });
    }
}
