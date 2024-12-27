package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.controller;

import com.spring_fundamentals.ExamenFundamentals.artists.application.IArtistService;
import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.ArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.UpdateArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistGenreDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private IArtistService artistService;

    @PostMapping
    public ResponseEntity<ArtistDTOOut> createOne(@Valid @RequestBody ArtistDTO artist) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.createOne(artist));
    }

    @GetMapping
    public ResponseEntity<List<ArtistGenreDTO>> getAllArtists() {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getAllArtists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistGenreDTO> getArtistByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getArtistByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistDTOOut> updateArtist(@PathVariable Long id, @Valid @RequestBody UpdateArtistDTO artistDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.updateArtist(id, artistDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtistByID(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

}
