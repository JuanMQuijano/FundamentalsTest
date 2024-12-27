package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongDTOOut;

import java.util.List;

public class PlaylistDTOOut {

    private String name;

    private String description;

    private List<SongDTOOut> songs;

    public PlaylistDTOOut() {
    }

    public PlaylistDTOOut(String name, String description, List<SongDTOOut> songs) {
        this.name = name;
        this.description = description;
        this.songs = songs;
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

    public List<String> getSongs() {
        return songs.stream().map(SongDTOOut::getName).toList();
    }

    public void setSongs(List<SongDTOOut> songs) {
        this.songs = songs;
    }
}
