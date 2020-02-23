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
import javax.persistence.ManyToOne;
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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "artist_Id", foreignKey = @ForeignKey(name = "fk_artist_song"), nullable=false)
  private Artist artist;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "song_albums", joinColumns = {
      @JoinColumn(name = "songs_id", referencedColumnName = "song_id", foreignKey = @ForeignKey(name = "fk_song_album")) }, inverseJoinColumns = {
          @JoinColumn(name = "albums_id", referencedColumnName = "album_id", foreignKey = @ForeignKey(name = "fk_album_song")) })
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
  public Song(String name, Date releaseDate, Integer year, Artist artist, Set<Album> albums) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artist = artist;
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
    return "Song [artist=" + artist + ", name=" + name + ", year=" + year + "]";
  }

  public void addAlbum(Album album) {
    this.albums.add(album);
    album.getSongs().add(this);
  }

  public void removeAlbum(Album album) {
    this.albums.remove(album);
    album.getSongs().remove(this);
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
    result = prime * result + ((artist == null) ? 0 : artist.hashCode());
    result = prime * result + ((songId == null) ? 0 : songId.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    if (artist == null) {
      if (other.artist != null)
        return false;
    } else if (!artist.equals(other.artist))
      return false;
    if (songId == null) {
      if (other.songId != null)
        return false;
    } else if (!songId.equals(other.songId))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
