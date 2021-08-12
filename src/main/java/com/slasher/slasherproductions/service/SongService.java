package com.slasher.slasherproductions.service;

import com.slasher.slasherproductions.entiy.Song;
import com.slasher.slasherproductions.entiy.SongFK;

import java.util.List;

public interface SongService {
    Song createSong(Song song);
    void deleteSongById(SongFK songFK);
    Song updateSong(Song song);
    Song getSongById(SongFK songFK);
    List<Song> getAllSongs();
    List<Song> getSongsByAlbum(long idAlbum);
    List<Song> getSongsByAuthor(long idAuthor);
}
