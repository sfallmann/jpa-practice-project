package com.sfallmann.jpah2ex.service;

import java.util.Set;

import com.sfallmann.jpah2ex.domain.Album;
import com.sfallmann.jpah2ex.repository.AlbumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AlbumService
 */
@Service
public class AlbumService {

  private AlbumRepository albumRepository;

  /**
   * @param albumRepository
   */
  @Autowired
  public AlbumService(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  public Set<Album> getAlbums() {
    return (Set<Album>)albumRepository.findAll();
  }

  public Album getAlbumById(Long id) {
    return albumRepository.findById(id).orElse(null);
  }
  
  public Set<Album> getAlbumByArtistId(Long artistId) {
    return albumRepository.findAlbumByArtistArtistId(artistId);
  }

  public Set<Album> getAlbumByArtistName(String artistName) {
    return albumRepository.findAlbumByArtistName(artistName);
  }

}