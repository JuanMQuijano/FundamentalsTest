package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto;

import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.GenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.UpdateGenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreAndArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IGenreMapper {

    IGenreMapper INSTANCE = Mappers.getMapper(IGenreMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    GenreDTOOut genreToGenreDTOOut(GenreEntity genre);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "artists", target = "artists")
    GenreAndArtistDTOOut genreToGenreAndArtistDTO(GenreEntity genre);

    @Mapping(source = "name", target = "newName")
    @Mapping(source = "description", target = "newDescription")
    UpdateGenreDTO genreToGenreUpdateDTO(GenreEntity oldGenre);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    GenreEntity DTOToEntity(GenreDTO genreDTO);
}
