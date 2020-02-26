package com.sfallmann.jpah2ex.repository;

import java.util.Set;

import com.sfallmann.jpah2ex.domain.Album;

import org.springframework.data.repository.CrudRepository;

/**
 * AlbumRepository
 */
public interface AlbumRepository extends CrudRepository<Album, Long>{

  public Set<Album> findAlbumByArtistsArtistId(Long artistId);
  public Set<Album> findAlbumByArtistsName(String artistName);
}