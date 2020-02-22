package com.sfallmann.jpah2ex.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.sfallmann.jpah2ex.domain.Artist;
import com.sfallmann.jpah2ex.jsonview.Views;
import com.sfallmann.jpah2ex.service.ArtistService;

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
  @JsonView(Views.Default.class)
  public List<Artist> allArtists(){
    return artistService.getArtists();
  }

  @RequestMapping("/{id}")
  @JsonView(Views.Detailed.class)
  public Artist artistById(@PathVariable Long id){
    return artistService.getArtistById(id);
  }
  
}