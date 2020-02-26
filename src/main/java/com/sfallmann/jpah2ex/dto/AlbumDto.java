package com.sfallmann.jpah2ex.dto;

import java.util.Date;

/**
 * AlbumDto
 */
public class AlbumDto {

  private Long albumId;
  private String name;
  private Date releaseDate;
  private Integer year;

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
   * 
   */
  public AlbumDto() {
  }

  /**
   * @param albumId
   * @param name
   * @param releaseDate
   * @param year
   */
  public AlbumDto(Long albumId, String name, Date releaseDate, Integer year) {
    this.albumId = albumId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
  }
}