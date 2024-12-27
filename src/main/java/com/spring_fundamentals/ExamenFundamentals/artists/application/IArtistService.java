package com.spring_fundamentals.ExamenFundamentals.artists.application;

import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.ArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.UpdateArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistGenreDTO;

import java.util.List;

public interface IArtistService {

    ArtistDTOOut createOne(ArtistDTO artist);

    List<ArtistGenreDTO> getAllArtists();

    ArtistGenreDTO getArtistByID(Long id);

    ArtistDTOOut updateArtist(Long id, UpdateArtistDTO artist);

    void deleteArtist(Long id);

}
