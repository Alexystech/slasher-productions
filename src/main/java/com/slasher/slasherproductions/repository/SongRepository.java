package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Song;
import com.slasher.slasherproductions.entiy.SongFK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, SongFK> {

    @Query(value = "SELECT s FROM Song s WHERE s.album.idAlbum = :idAlbum")
    Optional<List<Song>> findSongsByAlbum(@Param("idAlbum") long idAlbum);

    @Query(value = "SELECT s FROM Song s WHERE s.idSong.idAuthor = :idAuthor")
    Optional<List<Song>> findSongsByAuthor(@Param("idAuthor") long idAuthor);

}
