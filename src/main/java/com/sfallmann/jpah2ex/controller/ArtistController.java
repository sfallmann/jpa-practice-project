package com.sfallmann.jpah2ex.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonView;
import com.sfallmann.jpah2ex.domain.Artist;
import com.sfallmann.jpah2ex.dto.ArtistDto;
import com.sfallmann.jpah2ex.jsonview.Views;
import com.sfallmann.jpah2ex.service.ArtistService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ArtistController
 */
@RestController
@RequestMapping("artists")
public class ArtistController {

  private ArtistService artistService;

  @Autowired
  public ArtistController(ArtistService artistService) {
    this.artistService = artistService;
  }

  @RequestMapping("")
  public List<ArtistDto> allArtists() {
    return artistService.getArtists().stream().map(this::convertToDto).collect(Collectors.toList());
  }

  @RequestMapping("/{id}")
  @JsonView(Views.Detailed.class)
  public Artist artistById(@PathVariable Long id) {
    return artistService.getArtistById(id);
  }

  private ArtistDto convertToDto(Artist artist) {
    ModelMapper modelMapper = new ModelMapper();
    ArtistDto mm = modelMapper.map(artist, ArtistDto.class);
    System.out.println("ArtistDto ################################################# " + artist.toString());
    return mm;
  }
}