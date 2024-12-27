package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;

import java.util.List;

public class ArtistFullInfoDTO extends ArtistGenreDTO {

    private List<AlbumEntity> albums;

    public ArtistFullInfoDTO(String name, GenreDTOOut genre, List<AlbumEntity> albums) {
        super(name, genre);
        this.albums = albums;
    }

    public List<String> getAlbums() {
        return albums.stream().map(AlbumEntity::getName).toList();
    }

    public void setAlbums(List<AlbumEntity> albums) {
        this.albums = albums;
    }
}
