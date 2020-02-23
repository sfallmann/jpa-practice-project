package com.sfallmann.jpah2ex.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * Artist
 */
@Entity
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="artist_id")
  private Long artistId;
  private String name;
  private String genre;

  @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
  private Set<Album> albums;

  @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
  private Set<Song> songs;

  protected Artist() {
  }

  /**
   * @param name
   * @param genre
   * @param albums
   */
  public Artist(String name, String genre, Set<Album> albums, Set<Song> songs) {
    this.name = name;
    this.genre = genre;
    this.albums = albums;
    this.songs = songs;
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
  public Set<Album> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(Set<Album> albums) {
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