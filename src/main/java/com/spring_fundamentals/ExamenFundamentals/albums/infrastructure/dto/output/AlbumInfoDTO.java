package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;

import java.time.LocalDate;
import java.util.List;

public class AlbumInfoDTO {

    private String name;

    @JsonProperty(value = "release_date")
    private LocalDate releaseDate;

    private ArtistEntity artist;

    private List<SongEntity> songs;

    public AlbumInfoDTO() {
    }

    public AlbumInfoDTO(String name, LocalDate releaseDate, ArtistEntity artist, List<SongEntity> songs) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.artist = artist;
        this.songs = songs;
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

    public List<String> getSongs() {
        return songs.stream().map(SongEntity::getName).toList();
    }

    public void setSongs(List<SongEntity> songs) {
        this.songs = songs;
    }

    public String getArtist() {
        return artist.getName();
    }

    public void setArtist(ArtistEntity artist) {
        this.artist = artist;
    }
}
