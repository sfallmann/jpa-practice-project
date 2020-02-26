package com.sfallmann.jpah2ex.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

  public Set<?> findByCriteria(Map<String, String> criterias, Class<?> cls) {
    List<Artist> artists = ((List<Artist>) artistRepository.findAll((root, query, criteriaBuilder) -> {
      return Utils.filterBuilder(root, query, criteriaBuilder, criterias);
    }));

    if (cls == ArtistDetailsDto.class) {
      return artists.stream().map(this::mapArtistToArtistDetailsDto).collect(Collectors.toSet());
    } else {
      return artists.stream().map(this::mapArtistToArtistDto).collect(Collectors.toSet());
    }
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