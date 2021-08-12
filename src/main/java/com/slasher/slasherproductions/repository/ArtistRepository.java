package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    @Query(value = "SELECT a FROM Artist a WHERE a.musicalGroup.idMusicalGroup = :idMusicalGroup")
    Optional<List<Artist>> findArtistByMusicalGroup(@Param("idMusicalGroup") long idMusicalGroup);

}
