package com.sfallmann.jpah2ex.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * ArtistDto
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "artistId")
public class ArtistDto {

  private Long artistId;
  private String name;
  private String genre;

  @JsonManagedReference
  private Set<AlbumDto> albums;

  @JsonIgnore
  private Set<SongDto> songs;

  /**
   * @return the artistId
   */
  public Long getArtistId() {
    return artistId;
  }

  /**
   * @param artistId the artistId to set
   */
  public void setArtistId(Long artistId) {
    this.artistId = artistId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the genre
   */
  public String getGenre() {
    return genre;
  }

  /**
   * @param genre the genre to set
   */
  public void setGenre(String genre) {
    this.genre = genre;
  }

  /**
   * @return the albums
   */
  public Set<AlbumDto> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(Set<AlbumDto> albums) {
    this.albums = albums;
  }

  /**
   * @return the songs
   */
  public Set<SongDto> getSongs() {
    return songs;
  }

  /**
   * @param songs the songs to set
   */
  public void setSongs(Set<SongDto> songs) {
    this.songs = songs;
  }

  public ArtistDto() {
  }

  /**
   * @param artistId
   * @param name
   * @param genre
   * @param albums
   * @param songs
   */
  public ArtistDto(Long artistId, String name, String genre, Set<AlbumDto> albums, Set<SongDto> songs) {
    this.artistId = artistId;
    this.name = name;
    this.genre = genre;
    this.albums = albums;
    this.songs = songs;
  }
}