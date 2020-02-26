package com.sfallmann.jpah2ex.controller;

import java.util.List;

import com.sfallmann.jpah2ex.dto.ArtistDetailsDto;
import com.sfallmann.jpah2ex.service.ArtistService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public List<?> allArtists(@RequestParam(defaultValue = "false") boolean withDetails) {
    if (withDetails == true)
      return artistService.getArtistsWithDetails();
    return artistService.getArtists();
  }

  @RequestMapping("/{artistId}")
  public ArtistDetailsDto artistById(@PathVariable Long artistId) {
    return artistService.getArtistByArtistId(artistId);
  }
}