package com.sfallmann.jpah2ex.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sfallmann.jpah2ex.jsonview.Views;

/**
 * Artist
 */
@Entity
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
  property = "id")  
  @JsonView(Views.Default.class)
  private Long id;

  @JsonView(Views.Default.class)
  private String name;

  @JsonView(Views.Default.class)
  private String genre;

  @OneToMany(mappedBy = "artist")
  @JsonView(Views.Detailed.class)
  @JsonManagedReference
  private List<Album> albums;

  protected Artist() {
  }

  /**
   * @param name
   * @param genre
   * @param albums
   */
  public Artist(String name, String genre, List<Album> albums) {
    this.name = name;
    this.genre = genre;
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
   * @return the genre
   */
  public String getGenre() {
    return genre;
  }

  /**
   * @param genre the genre to set
   */
  public void setGenre(String genre) {
    this.genre = genre;
  }

  /**
   * @return the albums
   */
  public List<Album> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */

  @Override
  public String toString() {
    return "Artist [genre=" + genre + ", name=" + name + "]";
  }

}