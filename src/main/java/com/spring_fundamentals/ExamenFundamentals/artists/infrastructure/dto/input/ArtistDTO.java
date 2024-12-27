package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistDTO {

    @NotBlank
    @Size(min = 3, max = 25, message = "Artist name should be a value between {min} and {max}")
    private String name;

    @JsonProperty(value = "genre_id")
    @NotBlank
    @Min(value = 1, message = "Genre ID Must have a minimum value of ${value}")
    private Long genreId;

    public ArtistDTO() {
    }

    public ArtistDTO(String name, Long genreId) {
        this.name = name;
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }
}
