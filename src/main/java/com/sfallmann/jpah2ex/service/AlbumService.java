package com.sfallmann.jpah2ex.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sfallmann.jpah2ex.Utils;
import com.sfallmann.jpah2ex.domain.Album;
import com.sfallmann.jpah2ex.dto.AlbumDetailsDto;
import com.sfallmann.jpah2ex.dto.AlbumDto;
import com.sfallmann.jpah2ex.repository.AlbumRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AlbumService
 */
@Service
public class AlbumService {

  private AlbumRepository albumRepository;

  /**
   * @param albumRepository
   */
  @Autowired
  public AlbumService(AlbumRepository albumRepository) {
    this.albumRepository = albumRepository;
  }

  public List<AlbumDetailsDto> findByCriteria(Map<String, String> criterias) {
    return ((List<Album>) albumRepository.findAll((root, query, criteriaBuilder) -> {
      return Utils.filterBuilder(root, query, criteriaBuilder, criterias);
    })).stream().map(this::mapAlbumToAlbumDetailsDto).collect(Collectors.toList());
  }

  public List<AlbumDto> getAlbums() {
    return ((List<Album>) albumRepository.findAll()).stream().map(this::mapAlbumToAlbumDto)
        .collect(Collectors.toList());
  }

  public List<AlbumDetailsDto> getAlbumsWithDetails() {
    return ((List<Album>) albumRepository.findAll()).stream().map(this::mapAlbumToAlbumDetailsDto)
        .collect(Collectors.toList());
  }

  public Album getAlbumById(Long id) {
    return albumRepository.findById(id).orElse(null);
  }

  public List<AlbumDetailsDto> getAlbumByArtistId(Long artistId) {
    return ((List<Album>) albumRepository.findAlbumByArtists_ArtistId(artistId)).stream()
        .map(this::mapAlbumToAlbumDetailsDto).collect(Collectors.toList());
  }

  public List<AlbumDetailsDto> getAlbumByArtistName(String artistName) {
    return ((List<Album>) albumRepository.findAlbumByArtistsName(artistName)).stream()
        .map(this::mapAlbumToAlbumDetailsDto).collect(Collectors.toList());
  }

  private AlbumDto mapAlbumToAlbumDto(Album album) {
    return Utils.modelMapper.map(album, AlbumDto.class);
  }

  private AlbumDetailsDto mapAlbumToAlbumDetailsDto(Album album) {
    return Utils.modelMapper.map(album, AlbumDetailsDto.class);
  }
}