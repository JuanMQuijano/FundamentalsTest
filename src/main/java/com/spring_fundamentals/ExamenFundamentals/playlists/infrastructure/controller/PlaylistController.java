package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.controller;

import com.spring_fundamentals.ExamenFundamentals.playlists.application.IPlaylistService;
import com.spring_fundamentals.ExamenFundamentals.playlists.domain.model.PlaylistEntity;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.input.PlaylistDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistListDTOOut;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private IPlaylistService playlistService;

    @PostMapping
    public ResponseEntity<PlaylistDTOOut> createOne(@Valid @RequestBody PlaylistDTO playlistEntity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.createOne(playlistEntity));
    }

    @GetMapping
    public ResponseEntity<List<PlaylistListDTOOut>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistInfoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.findByID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistDTOOut> updatePlaylist(@PathVariable Long id, @Valid @RequestBody PlaylistDTO playlist) {
        return ResponseEntity.status(HttpStatus.OK).body(playlistService.updatePlaylist(id, playlist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable Long id) {
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }

}
