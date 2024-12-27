package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.controller;

import com.spring_fundamentals.ExamenFundamentals.albums.application.IAlbumService;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.input.AlbumDTO;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumDTOOut;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumInfoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private IAlbumService albumService;

    @PostMapping
    public ResponseEntity<AlbumDTOOut> createOne(@Valid @RequestBody AlbumDTO album) {
        return ResponseEntity.status(HttpStatus.CREATED).body(albumService.createOne(album));
    }

    @GetMapping
    public ResponseEntity<List<AlbumDTOOut>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(albumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumInfoDTO> findByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(albumService.getAlbumByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumDTOOut> updateByID(@PathVariable Long id, @Valid @RequestBody AlbumDTO album) {
        return ResponseEntity.status(HttpStatus.OK).body(albumService.updateAlbum(id, album));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return ResponseEntity.noContent().build();
    }

}
