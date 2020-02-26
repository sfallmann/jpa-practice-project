package com.sfallmann.jpah2ex.controller;

import java.util.List;
import java.util.Map;

import com.sfallmann.jpah2ex.service.AlbumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * AlbumController
 */
@RestController
@RequestMapping("albums")
public class AlbumController {


  private AlbumService albumService;

  @Autowired
  public AlbumController(AlbumService albumService) {
    this.albumService = albumService;
  }

  @RequestMapping("")
  public List<?> allAlbums(
    @RequestParam(required = false) Map<String, String> allParams
    ) {      
    return albumService.findByCriteria(allParams);
  }
  
}