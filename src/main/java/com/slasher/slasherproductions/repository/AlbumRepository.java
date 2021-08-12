package com.slasher.slasherproductions.repository;

import com.slasher.slasherproductions.entiy.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

    @Query(value = "SELECT a FROM Album a WHERE a.registerToPH.idRegistersToPH.idProducerHouse = :idProducerHouse")
    Optional<List<Album>> findAlbumsByProducerHouse(@Param("idProducerHouse") long idProducerHouse);

}
