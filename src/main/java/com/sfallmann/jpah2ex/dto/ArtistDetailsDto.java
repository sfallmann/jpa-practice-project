package com.sfallmann.jpah2ex.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * ArtistDto
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "artistId")
public class ArtistDetailsDto {

  private Long artistId;
  private String name;
  private String genre;
  private Set<AlbumDetailsDto> albums;
  private Set<SongDetailsDto> songs;

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
  public Set<AlbumDetailsDto> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(Set<AlbumDetailsDto> albums) {
    this.albums = albums;
  }

  /**
   * @return the songs
   */
  public Set<SongDetailsDto> getSongs() {
    return songs;
  }

  /**
   * @param songs the songs to set
   */
  public void setSongs(Set<SongDetailsDto> songs) {
    this.songs = songs;
  }

  public ArtistDetailsDto() {
  }

  /**
   * @param artistId
   * @param name
   * @param genre
   * @param albums
   * @param songs
   */
  public ArtistDetailsDto(Long artistId, String name, String genre, Set<AlbumDetailsDto> albums, Set<SongDetailsDto> songs) {
    this.artistId = artistId;
    this.name = name;
    this.genre = genre;
    this.albums = albums;
    this.songs = songs;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((artistId == null) ? 0 : artistId.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ArtistDetailsDto other = (ArtistDetailsDto) obj;
    if (artistId == null) {
      if (other.artistId != null)
        return false;
    } else if (!artistId.equals(other.artistId))
      return false;
    return true;
  }
}