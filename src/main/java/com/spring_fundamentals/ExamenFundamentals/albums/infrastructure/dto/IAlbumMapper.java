package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.input.AlbumDTO;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumDTOOut;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAlbumMapper {

    IAlbumMapper INSTANCE = Mappers.getMapper(IAlbumMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "artistId", target = "artistId")
    AlbumDTO entityToAlbumDTO(AlbumEntity entity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "artist", target = "artist")
    AlbumDTOOut entityToAlbumDTOOut(AlbumEntity entity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "releaseDate", target = "releaseDate")
    @Mapping(source = "artist", target = "artist")
    @Mapping(source = "songs", target = "songs")
    AlbumInfoDTO entityToAlbumInfoDTO(AlbumEntity album);

    AlbumEntity toEntity(AlbumDTO entity);

}
