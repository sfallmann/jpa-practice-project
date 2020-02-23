package com.sfallmann.jpah2ex.service;

import java.util.List;

import com.sfallmann.jpah2ex.domain.Artist;
import com.sfallmann.jpah2ex.repository.ArtistRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ArtistService
 */
@Service
public class ArtistService {

  private ArtistRepository artistRepository;

  /**
   * 
   */
  @Autowired
  public ArtistService(ArtistRepository artistRepository){
    this.artistRepository = artistRepository;
  }
  
  public List<Artist> getArtists() {
    return (List<Artist>)artistRepository.findAll();
  }

  public Artist getArtistById(Long id) {
    return artistRepository.findById(id).orElse(null);
  }

  public void removeArtist(Long artistId) {
    artistRepository.deleteById(artistId);
  }
}