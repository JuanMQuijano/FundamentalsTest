package com.spring_fundamentals.ExamenFundamentals.playlists.application;

import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.input.PlaylistDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistListDTOOut;

import java.util.List;

public interface IPlaylistService {

    PlaylistDTOOut createOne(PlaylistDTO playlist);

    List<PlaylistListDTOOut> findAll();

    PlaylistInfoDTO findByID(Long id);

    PlaylistDTOOut updatePlaylist(Long id, PlaylistDTO playlistEntity);

    void deletePlaylist(Long id);

}
