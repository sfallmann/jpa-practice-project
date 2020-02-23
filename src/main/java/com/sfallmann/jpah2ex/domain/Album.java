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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "artist_Id", foreignKey = @ForeignKey(name = "fk_artist_album"), nullable=false)
  private Artist artist;

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
  public Album(String name, Date releaseDate, Integer year, Artist artist, Set<Song> songs) {
    this.name = name;
    this.releaseDate = releaseDate;
    this.year = year;
    this.artist = artist;
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
  public Set<Song> getSongs() {
    return songs;
  }

  /**
   * @param songs the songs to set
   */
  public void setSongs(Set<Song> songs) {
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

  public void addSong(Song song) {
    this.songs.add(song);
    song.getAlbums().add(this);
  }

  public void removeAlbum(Song song) {
    this.songs.remove(song);
    song.getAlbums().remove(this);
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
    result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
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
    Album other = (Album) obj;
    if (artist == null) {
      if (other.artist != null)
        return false;
    } else if (!artist.equals(other.artist))
      return false;
    if (albumId == null) {
      if (other.albumId != null)
        return false;
    } else if (!albumId.equals(other.albumId))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
