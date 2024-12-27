package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.controller;

import com.spring_fundamentals.ExamenFundamentals.genres.application.IGenreService;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.GenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.UpdateGenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreAndArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private IGenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTOOut> createGenre(@Valid @RequestBody GenreDTO genre) {
        return ResponseEntity.status(HttpStatus.CREATED).body(genreService.create(genre));
    }

    @GetMapping
    public ResponseEntity<List<GenreDTOOut>> getAllGenres() {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreAndArtistDTOOut> getGenreById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.getGenreById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateGenreDTO> updateGenre(@PathVariable Long id, @Valid @RequestBody UpdateGenreDTO genre) {
        return ResponseEntity.status(HttpStatus.OK).body(genreService.updateGenre(id, genre));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        genreService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
