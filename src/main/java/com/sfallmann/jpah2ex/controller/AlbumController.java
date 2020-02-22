package com.sfallmann.jpah2ex.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.sfallmann.jpah2ex.domain.Album;
import com.sfallmann.jpah2ex.jsonview.Views;
import com.sfallmann.jpah2ex.service.AlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AlbumController
 */
@RestController
@RequestMapping("/albums")
public class AlbumController {

  private AlbumService albumService;

  @Autowired
  public AlbumController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @RequestMapping("")
  @JsonView(Views.Default.class)
  public List<Album> allAlbums(
    @RequestParam(name = "artist_id", required = false) Long artistId,
    @RequestParam(name = "artist_name", required = false) String artistName
    ){

    if (artistId != null) {
      return albumService.getAlbumByArtistId(artistId);
    }
    if (artistName != null) {
      return albumService.getAlbumByArtistName(artistName);
    }
    return albumService.getAlbums();
  }

  @RequestMapping("/{id}")
  @JsonView(Views.Detailed.class)
  public Album artistById(@PathVariable Long id){
    return albumService.getAlbumById(id);
  }
  
}