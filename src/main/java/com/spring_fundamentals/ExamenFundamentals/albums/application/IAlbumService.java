package com.spring_fundamentals.ExamenFundamentals.albums.application;

import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.input.AlbumDTO;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumDTOOut;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumInfoDTO;

import java.util.List;

public interface IAlbumService {

    AlbumDTOOut createOne(AlbumDTO album);

    List<AlbumDTOOut> findAll();

    AlbumInfoDTO getAlbumByID(Long id);

    AlbumDTOOut updateAlbum(Long id, AlbumDTO album);

    void deleteAlbum(Long id);

}
