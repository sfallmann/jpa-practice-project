package com.sfallmann.jpah2ex.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sfallmann.jpah2ex.jsonview.Views;

@Entity
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")  
  @JsonView(Views.Default.class)
  private Long id;

  @JsonView(Views.Default.class)
  private String name;

  @JsonView(Views.Detailed.class)
  private Date releaseDate;
  
  @JsonView(Views.Default.class)
  private String year;

  @ManyToOne
  @JsonView(Views.Default.class)
  @JsonBackReference
  private Artist artist;
  
  @ManyToMany(mappedBy = "albums")
  @JsonView(Views.Default.class)
  private List<Song> songs;


  protected Album() {}

  /**
   * @param name
   * @param releaseDate
   * @param year
   * @param artist
   * @param songs
   */
  public Album(String name, Date releaseDate, String year, Artist artist, List<Song> songs) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artist = artist;
    this.songs = songs;
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
   * @return the songs
   */
  public List<Song> getSongs() {
    return songs;
  }

  /**
   * @param songs the songs to set
   */
  public void setSongs(List<Song> songs) {
    this.songs = songs;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "Album [artist=" + artist + ", name=" + name + ", year=" + year + "]";
  }

  
}
