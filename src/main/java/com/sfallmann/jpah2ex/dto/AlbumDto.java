package com.sfallmann.jpah2ex.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * AlbumDto
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "albumId")
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
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
    AlbumDto other = (AlbumDto) obj;
    if (albumId == null) {
      if (other.albumId != null)
        return false;
    } else if (!albumId.equals(other.albumId))
      return false;
    return true;
  }
}