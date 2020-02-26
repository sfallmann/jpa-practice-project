package com.sfallmann.jpah2ex.repository;

import com.sfallmann.jpah2ex.domain.Artist;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * ArtistRepository
 */
public interface ArtistRepository extends CrudRepository<Artist, Long>, JpaSpecificationExecutor<Artist> {

  public Artist findArtistByArtistId(Long artistId);
}