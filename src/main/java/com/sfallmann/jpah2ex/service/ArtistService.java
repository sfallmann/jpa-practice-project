package com.sfallmann.jpah2ex.service;

import java.util.List;
import java.util.stream.Collectors;

import com.sfallmann.jpah2ex.Utils;
import com.sfallmann.jpah2ex.domain.Artist;
import com.sfallmann.jpah2ex.dto.ArtistDetailsDto;
import com.sfallmann.jpah2ex.dto.ArtistDto;
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

  public List<ArtistDto> getArtists() {
    return ((List<Artist>)artistRepository.findAll())
    .stream().map(this::mapArtistToArtistDto).collect(Collectors.toList());
  }  

  public List<ArtistDetailsDto> getArtistsWithDetails() {
    return ((List<Artist>)artistRepository.findAll())
    .stream().map(this::mapArtistToArtistDetailsDto).collect(Collectors.toList());
  }

  public ArtistDetailsDto getArtistByArtistId(Long artistId) {
   return mapArtistToArtistDetailsDto(artistRepository.findArtistByArtistId(artistId));
  }

  public void removeArtist(Long artistId) {
    artistRepository.deleteById(artistId);
  }

  private ArtistDto mapArtistToArtistDto(Artist artist) {
    return Utils.modelMapper.map(artist, ArtistDto.class);
  }

  private ArtistDetailsDto mapArtistToArtistDetailsDto(Artist artist) {
    return Utils.modelMapper.map(artist, ArtistDetailsDto.class);
  }
}