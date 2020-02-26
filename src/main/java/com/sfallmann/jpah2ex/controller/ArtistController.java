package com.sfallmann.jpah2ex.controller;

import java.util.Map;
import java.util.Set;

import com.sfallmann.jpah2ex.dto.ArtistDetailsDto;
import com.sfallmann.jpah2ex.dto.ArtistDto;
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
  public Set<?> allArtists(@RequestParam(required = false) Map<String, String> allParams) {
    String details = allParams.get("details");
    if (details != null) {
      allParams.remove("details");
    }

    if (details.equals("true")) {
      return artistService.findByCriteria(allParams, ArtistDetailsDto.class);
    } else {
      return artistService.findByCriteria(allParams, ArtistDto.class);
    }

  }

  @RequestMapping("/{artistId}")
  public ArtistDetailsDto artistById(@PathVariable Long artistId) {
    return artistService.getArtistByArtistId(artistId);
  }
}