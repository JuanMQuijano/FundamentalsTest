package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto;

import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.input.SongDTO;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongDTOOut;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ISongMapper {

    ISongMapper INSTANCE = Mappers.getMapper(ISongMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "album", target = "artist")
    SongDTOOut entityToDTOOut(SongEntity entity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "duration", target = "duration")
    @Mapping(source = "album", target = "album")
    SongInfoDTO entityToDTOInfo(SongEntity entity);

    SongEntity toEntity(SongDTO entity);

}
