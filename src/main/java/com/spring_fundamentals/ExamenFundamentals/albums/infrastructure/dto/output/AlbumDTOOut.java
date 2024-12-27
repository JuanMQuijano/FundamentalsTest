package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;

import java.time.LocalDate;

public class AlbumDTOOut {

    private String name;

    @JsonProperty(value = "release_date")
    private LocalDate releaseDate;

    private ArtistEntity artist;

    public AlbumDTOOut() {
    }

    public AlbumDTOOut(String name, LocalDate releaseDate, ArtistEntity artist) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist.getName();
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
}
