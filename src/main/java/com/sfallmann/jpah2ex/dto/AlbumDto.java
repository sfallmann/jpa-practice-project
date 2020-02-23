package com.sfallmann.jpah2ex.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "albumId")
public class AlbumDto {


  private Long albumId;
  private String name;
  private Date releaseDate;
  private Integer year;
  @JsonBackReference
  private Long artistId;
  private Set<SongDto> songs;

  /**
   * @return the albumId
   */
  public Long getAlbumId() {
    return albumId;
  }

  /**
   * @param albumId the albumId to set
   */
  public void setAlbumId(Long albumId) {
    this.albumId = albumId;
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
   * @return the releaseDate
   */
  public Date getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate the releaseDate to set
   */
  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * @param year the year to set
   */
  public void setYear(Integer year) {
    this.year = year;
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

  /**
   * @param albumId
   * @param name
   * @param releaseDate
   * @param year
   * @param artistId
   * @param songs
   */
  public AlbumDto(Long albumId, String name, Date releaseDate, Integer year, Long artistId, Set<SongDto> songs) {
    this.albumId = albumId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artistId = artistId;
    this.songs = songs;
  }

  /**
   * 
   */
  public AlbumDto() {
  }
}
