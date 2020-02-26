package com.sfallmann.jpah2ex.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "songId")
public class SongDetailsDto {

  private Long songId;
  private String name;
  private Date releaseDate;
  private Integer year;
  private Set<ArtistDto> artists;  
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

  public SongDetailsDto() {
  }

  /**
   * @param songId
   * @param name
   * @param releaseDate
   * @param year
   * @param artistId
   * @param albums
   */
  public SongDetailsDto(Long songId, String name, Date releaseDate, Integer year, Set<ArtistDto> artists, Set<AlbumDto> albums) {
    this.songId = songId;
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artists = artists;
    this.albums = albums;
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
    SongDetailsDto other = (SongDetailsDto) obj;
    if (songId == null) {
      if (other.songId != null)
        return false;
    } else if (!songId.equals(other.songId))
      return false;
    return true;
  }
}
