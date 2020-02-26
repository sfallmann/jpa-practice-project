package com.sfallmann.jpah2ex.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "albumId")
public class AlbumDetailsDto {


  private Long albumId;
  private String name;
  private Date releaseDate;
  private Integer year;
  private Set<ArtistDto> artists;
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
   * @param artists
   * @param songs
   */
  public AlbumDetailsDto(Long albumId, String name, Date releaseDate, Integer year, Set<ArtistDto> artists, Set<SongDto> songs) {
    this.albumId = albumId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artists = artists;
    this.songs = songs;
  }

  /**
   * 
   */
  public AlbumDetailsDto() {
  }

  /**
   * @return the artists
   */
  public Set<ArtistDto> getArtists() {
    return artists;
  }

  /**
   * @param artists the artists to set
   */
  public void setArtists(Set<ArtistDto> artists) {
    this.artists = artists;
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
    AlbumDetailsDto other = (AlbumDetailsDto) obj;
    if (albumId == null) {
      if (other.albumId != null)
        return false;
    } else if (!albumId.equals(other.albumId))
      return false;
    return true;
  }
}
