package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class AlbumDTO {

    @NotBlank
    @Size(min = 3, max = 60, message = "Album name must have a minimum value of ${value}")
    private String name;

    @JsonProperty(value = "release_date")
    private LocalDate releaseDate;

    @JsonProperty(value = "artist_id")
    @NotBlank
    @Min(value = 1, message = "Genre ID Must have a minimum value of ${value}")
    private Long artistId;

    public AlbumDTO() {
    }

    public AlbumDTO(String name, LocalDate releaseDate, Long artistId) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artistId = artistId;
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

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }
}
