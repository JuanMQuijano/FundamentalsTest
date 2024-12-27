package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;

public class ArtistGenreDTO {

    private String name;

    private GenreDTOOut genre;

    public ArtistGenreDTO() {
    }

    public ArtistGenreDTO(String name, GenreDTOOut genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre.getName();
    }

    public void setGenre(GenreDTOOut genre) {
        this.genre = genre;
    }
}
