package com.sfallmann.jpah2ex.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "songId")
public class SongDto {

  private Long songId;
  private String name;
  private Date releaseDate;
  private Integer year;
  @JsonBackReference
  private Long artistId;
  private Set<AlbumDto> albums;

  /**
   * @return the songId
   */
  public Long getSongId() {
    return songId;
  }

  /**
   * @param songId the songId to set
   */
  public void setSongId(Long songId) {
    this.songId = songId;
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

  public SongDto() {
  }

  /**
   * @param songId
   * @param name
   * @param releaseDate
   * @param year
   * @param artistId
   * @param albums
   */
  public SongDto(Long songId, String name, Date releaseDate, Integer year, Long artistId, Set<AlbumDto> albums) {
    this.songId = songId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artistId = artistId;
    this.albums = albums;
  }
}
