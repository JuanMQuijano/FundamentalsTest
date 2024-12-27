package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output;

import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistGenreDTO;

import java.util.List;

public class GenreAndArtistDTOOut extends GenreDTOOut {

    private List<ArtistGenreDTO> artists;

    public GenreAndArtistDTOOut() {
    }

    public GenreAndArtistDTOOut(String name, String description, List<ArtistGenreDTO> artists) {
        super(name, description);
        this.artists = artists;
    }

    public List<String> getArtists() {
        return artists.stream().map(a -> a.getName()).toList();
    }

    public void setArtists(List<ArtistGenreDTO> artists) {
        this.artists = artists;
    }
}
