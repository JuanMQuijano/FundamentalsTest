package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;

public class SongInfoDTO {

    private String name;

    private double duration;

    private AlbumEntity album;

    private String artist;

    private String genre;

    public SongInfoDTO() {
    }

    public SongInfoDTO(String name, double duration, AlbumEntity album) {
        this.name = name;
        this.duration = duration;
        this.album = album;
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

    public String getAlbum() {
        return album.getName();
    }

    public void setAlbum(AlbumEntity album) {
        this.album = album;
    }

    public String getArtist() {
        return album.getArtist().getName();
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return album.getArtist().getGenre().getName();
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
