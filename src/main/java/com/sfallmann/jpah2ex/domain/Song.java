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
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="song_id")
  private Long songId;

  private String name;

  @Temporal(TemporalType.DATE)
  private Date releaseDate;
  private Integer year;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "song_artist", joinColumns = {
      @JoinColumn(name = "song_id", referencedColumnName = "song_id", foreignKey = @ForeignKey(name = "fk_song_artist")) }, inverseJoinColumns = {
          @JoinColumn(name = "artist_id", referencedColumnName = "artist_id", foreignKey = @ForeignKey(name = "fk_artist_song")) })
  Set<Artist> artists;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "song_album", joinColumns = {
      @JoinColumn(name = "song_id", referencedColumnName = "song_id", foreignKey = @ForeignKey(name = "fk_song_album")) }, inverseJoinColumns = {
          @JoinColumn(name = "album_id", referencedColumnName = "album_id", foreignKey = @ForeignKey(name = "fk_album_song")) })
  private Set<Album> albums;

  protected Song() {
  }

  /**
   * @param name
   * @param releaseDate
   * @param year
   * @param artist
   * @param albums
   */
  public Song(String name, Date releaseDate, Integer year, Set<Artist> artists, Set<Album> albums) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artists = artists;
    this.albums = albums;
  }

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
  public Set<Album> getAlbums() {
    return albums;
  }

  /**
   * @param albums the albums to set
   */
  public void setAlbums(Set<Album> albums) {
    this.albums = albums;
  }

  public void addAlbum(Album album) {
    this.albums.add(album);
    album.getSongs().add(this);
  }

  public void removeAlbum(Album album) {
    this.albums.remove(album);
    album.getSongs().remove(this);
  }

  /**
   * @return the artists
   */
  public Set<Artist> getArtists() {
    return artists;
  }

  /**
   * @param artists the artists to set
   */
  public void setArtists(Set<Artist> artists) {
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
    Song other = (Song) obj;
    if (songId == null) {
      if (other.songId != null)
        return false;
    } else if (!songId.equals(other.songId))
      return false;
    return true;
  }

}
