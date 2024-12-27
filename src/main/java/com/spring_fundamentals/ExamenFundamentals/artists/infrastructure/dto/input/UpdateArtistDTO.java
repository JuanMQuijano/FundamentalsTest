package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UpdateArtistDTO {

    @JsonProperty(value = "new_name")
    @NotBlank
    @Size(min = 3, max = 25, message = "Artist name should be a value between {min} and {max}")
    private String newName;

    @JsonProperty(value = "new_genre_id")
    @NotBlank
    @Min(value = 1, message = "Genre ID Must have a minimum value of ${value}")
    private Long newGenreId;

    public UpdateArtistDTO() {
    }

    public UpdateArtistDTO(String newName, Long newGenreId) {
        this.newName = newName;
        this.newGenreId = newGenreId;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Long getNewGenreId() {
        return newGenreId;
    }

    public void setNewGenreId(Long newGenreId) {
        this.newGenreId = newGenreId;
    }
}
