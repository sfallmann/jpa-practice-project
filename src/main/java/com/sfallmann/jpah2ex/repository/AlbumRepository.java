package com.sfallmann.jpah2ex.repository;

import java.util.List;

import com.sfallmann.jpah2ex.domain.Album;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * AlbumRepository
 */
@Repository
@Transactional
public interface AlbumRepository extends CrudRepository<Album, Long>, JpaSpecificationExecutor<Album>{


  public List<Album> findAlbumByArtists_ArtistId(Long albumId);
  public List<Album> findAlbumByArtistsName(String artistName);
}