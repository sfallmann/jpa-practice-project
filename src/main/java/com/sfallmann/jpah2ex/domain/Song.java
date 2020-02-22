package com.sfallmann.jpah2ex.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.sfallmann.jpah2ex.jsonview.Views;

@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  
  @JsonView(Views.Default.class)
  private Long id;

  @JsonView(Views.Default.class)
  private String name;
  private Date releaseDate;
  private String year;

  @ManyToOne
  private Artist artist;

  @ManyToMany
  private List<Album> albums;

  protected Song() {}

  /**
   * @param name
   * @param releaseDate
   * @param year
   * @param artist
   * @param albums
   */
  public Song(String name, Date releaseDate, String year, Artist artist, List<Album> albums) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artist = artist;
    this.albums = albums;
  }

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
    this.id = id;
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
  public String getYear() {
    return year;
  }

  /**
   * @param year the year to set
   */
  public void setYear(String year) {
    this.year = year;
  }

  /**
   * @return the artist
   */
  public Artist getArtist() {
    return artist;
  }

  /**
   * @param artist the artist to set
   */
  public void setArtist(Artist artist) {
    this.artist = artist;
  }

  /**
   * @return the albums
   */
  public List<Album> getalbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setalbums(List<Album> albums) {
    this.albums = albums;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "Song [artist=" + artist + ", name=" + name + ", year=" + year + "]";
  }

  
}
