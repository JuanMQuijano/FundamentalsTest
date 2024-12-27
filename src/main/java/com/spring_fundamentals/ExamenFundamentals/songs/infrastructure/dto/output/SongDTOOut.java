package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;

public class SongDTOOut {

    private String name;

    private double duration;

    private AlbumEntity artist;

    public SongDTOOut() {
    }

    public SongDTOOut(String name, double duration, AlbumEntity album) {
        this.name = name;
        this.duration = duration;
        this.artist = album;
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

    public String getArtist() {
        return artist.getArtist().getName();
    }

    public void setArtist(AlbumEntity artist) {
        this.artist = artist;
    }
}
