package com.spring_fundamentals.ExamenFundamentals.genres.application;

import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.GenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.UpdateGenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreAndArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;

import java.util.List;

public interface IGenreService {

    GenreDTOOut create(GenreDTO genre);

    List<GenreDTOOut> getAll();

    GenreAndArtistDTOOut getGenreById(Long id);

    void deleteById(Long id);

    UpdateGenreDTO updateGenre(Long id, UpdateGenreDTO genre);
}
