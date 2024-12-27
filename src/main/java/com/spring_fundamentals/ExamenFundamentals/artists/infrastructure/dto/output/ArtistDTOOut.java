package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;

public class ArtistDTOOut {

    private String name;

    private GenreEntity genre;

    public ArtistDTOOut() {
    }

    public ArtistDTOOut(String name, GenreEntity genre) {
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

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }
}
