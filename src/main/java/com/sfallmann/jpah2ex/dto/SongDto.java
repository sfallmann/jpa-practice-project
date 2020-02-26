package com.sfallmann.jpah2ex.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * SongDto
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "songId")
public class SongDto {

  private Long songId;
  private String name;
  private Date releaseDate;
  private Integer year;

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
   * 
   */
  public SongDto() {
  }

  /**
   * @param songId
   * @param name
   * @param releaseDate
   * @param year
   */
  public SongDto(Long songId, String name, Date releaseDate, Integer year) {
    this.songId = songId;
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
    result = prime * result + ((songId == null) ? 0 : songId.hashCode());
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
    SongDto other = (SongDto) obj;
    if (songId == null) {
      if (other.songId != null)
        return false;
    } else if (!songId.equals(other.songId))
      return false;
    return true;
  }
  
}