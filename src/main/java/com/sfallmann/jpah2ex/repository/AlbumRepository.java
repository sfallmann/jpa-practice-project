package com.sfallmann.jpah2ex.repository;

import java.util.List;

import com.sfallmann.jpah2ex.domain.Album;

import org.springframework.data.repository.CrudRepository;

/**
 * AlbumRepository
 */
public interface AlbumRepository extends CrudRepository<Album, Long>{

  public List<Album> findAlbumByArtistId(Long artistId);
  public List<Album> findAlbumByArtistName(String artistName);
}