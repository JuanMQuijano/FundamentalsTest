package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.controller;

import com.spring_fundamentals.ExamenFundamentals.songs.application.ISongService;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.input.SongDTO;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongDTOOut;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongInfoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private ISongService songService;

    @PostMapping
    public ResponseEntity<SongDTOOut> createOne(@Valid @RequestBody SongDTO songEntity) {
            return ResponseEntity.status(HttpStatus.CREATED).body(songService.createOne(songEntity));
    }

    @GetMapping
    public ResponseEntity<List<SongDTOOut>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(songService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongInfoDTO> findByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(songService.findByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongDTOOut> updateByID(@PathVariable Long id, @Valid @RequestBody SongDTO song) {
        return ResponseEntity.status(HttpStatus.OK).body(songService.updateSong(id, song));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }


}
