package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PlaylistDTO {

    @NotBlank
    @Size(min = 3, max = 10, message = "Genre name should be a value between {min} and {max}")
    private String name;

    @NotBlank
    @Size(min = 5, message = "Genre description should be a value with at least {min} characters")
    private String description;

    @JsonProperty(value = "songs")
    private List<Long> songsId;

    public PlaylistDTO() {
    }

    public PlaylistDTO(String name, String description, List<Long> songsId) {
        this.name = name;
        this.description = description;
        this.songsId = songsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getSongsId() {
        return songsId;
    }

    public void setSongsId(List<Long> songsId) {
        this.songsId = songsId;
    }
}
