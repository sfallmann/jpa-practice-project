package com.sfallmann.jpah2ex.dto;

/**
 * ArtistDto
 */
public class ArtistDto {

  private Long artistId;
  private String name;
  private String genre;

  /**
   * 
   */
  public ArtistDto() {
  }

  /**
   * @param artistId
   * @param name
   * @param genre
   */
  public ArtistDto(Long artistId, String name, String genre) {
    this.artistId = artistId;
    this.name = name;
    this.genre = genre;
  }

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
}