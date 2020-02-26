package com.sfallmann.jpah2ex.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="album_id")
  private Long albumId;

  private String name;

  @Temporal(TemporalType.DATE)
  private Date releaseDate;

  private Integer year;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "album_artist", joinColumns = {
      @JoinColumn(name = "album_id", referencedColumnName = "album_id", foreignKey = @ForeignKey(name = "fk_album_artist")) }, inverseJoinColumns = {
          @JoinColumn(name = "artist_id", referencedColumnName = "artist_id", foreignKey = @ForeignKey(name = "fk_artist_album")) })
  Set<Artist> artists;

  @ManyToMany(mappedBy = "albums", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Set<Song> songs;

  protected Album() {
  }

  /**
   * @param name
   * @param releaseDate
   * @param year
   * @param artist
   * @param songs
   */
  public Album(String name, Date releaseDate, Integer year, Set<Artist> artists, Set<Song> songs) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artists = artists;
    this.songs = songs;
  }

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
  public Set<Song> getSongs() {
    return songs;
  }

  /**
   * @param songs the songs to set
   */
  public void setSongs(Set<Song> songs) {
    this.songs = songs;
  }

}
