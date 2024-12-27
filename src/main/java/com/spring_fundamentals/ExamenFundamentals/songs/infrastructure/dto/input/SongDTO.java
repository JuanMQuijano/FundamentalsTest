package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SongDTO {

    @NotBlank
    @Size(min = 3, max = 25, message = "Song names should be a value between {min} and {max} characters")
    private String name;

    private double duration;

    @JsonProperty(value = "album_id")
    @Min(value = 1, message = "Album ID Must be a value from ${value}")
    private Long albumId;

    public SongDTO() {
    }

    public SongDTO(String name, double duration, Long albumId) {
        this.name = name;
        this.duration = duration;
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
}
