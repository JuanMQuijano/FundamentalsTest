package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto;

import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.ArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistFullInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistGenreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IArtistMapper {

    IArtistMapper INSTANCE = Mappers.getMapper(IArtistMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "genre", target = "genre")
    ArtistDTOOut artistEntityToArtistDTO(ArtistEntity artist);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "genre", target = "genre")
    ArtistGenreDTO artistListDTO(ArtistEntity artist);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "albums", target = "albums")
    ArtistFullInfoDTO artistToInfoDTO(ArtistEntity artist);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "genreId", target = "genreId")
    ArtistEntity toEntity(ArtistDTO artist);

}
