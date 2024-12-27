package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto;

import com.spring_fundamentals.ExamenFundamentals.playlists.domain.model.PlaylistEntity;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.input.PlaylistDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistListDTOOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPlaylistMapper {

    IPlaylistMapper INSTANCE = Mappers.getMapper(IPlaylistMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "songs", target = "songs")
    PlaylistDTOOut entityToDTO(PlaylistEntity entity);

    PlaylistListDTOOut entitiesToListDTO(PlaylistEntity entity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "songs", target = "songs")
    PlaylistInfoDTO entityToInfoDTO(PlaylistEntity entity);

    @Mapping(source = "songsId", target = "songsId")
    PlaylistEntity toEntity(PlaylistDTO entity);

}
