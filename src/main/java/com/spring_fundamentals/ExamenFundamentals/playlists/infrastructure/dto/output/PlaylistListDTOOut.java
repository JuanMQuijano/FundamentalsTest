package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output;

public class PlaylistListDTOOut {

    private String name;

    private String description;

    public PlaylistListDTOOut() {
    }

    public PlaylistListDTOOut(String name, String description) {
        this.name = name;
        this.description = description;
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
}

