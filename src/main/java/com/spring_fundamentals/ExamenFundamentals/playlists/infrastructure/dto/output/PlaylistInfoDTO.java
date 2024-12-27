package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;

import java.util.List;

public class PlaylistInfoDTO {

    private String name;

    private String description;

    private List<SongEntity> songs;

    public PlaylistInfoDTO() {
    }

    public PlaylistInfoDTO(String name, String description, List<SongEntity> songs) {
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
        return songs.stream().map(s -> s.getName() + " - " + s.getAlbum().getName()).toList();
    }

    public void setSongs(List<SongEntity> songs) {
        this.songs = songs;
    }
}
