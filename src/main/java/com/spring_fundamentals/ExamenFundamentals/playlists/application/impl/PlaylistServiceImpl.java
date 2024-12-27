package com.spring_fundamentals.ExamenFundamentals.playlists.application.impl;

import com.spring_fundamentals.ExamenFundamentals.exception.ObjectNotFoundExcept;
import com.spring_fundamentals.ExamenFundamentals.playlists.application.IPlaylistService;
import com.spring_fundamentals.ExamenFundamentals.playlists.domain.model.PlaylistEntity;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.IPlaylistMapper;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.input.PlaylistDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.dto.output.PlaylistListDTOOut;
import com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.repository.IPlaylistRepository;
import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.repository.ISongRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements IPlaylistService {

    @Autowired
    private IPlaylistRepository playlistRepository;

    @Autowired
    private ISongRepository songRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public PlaylistDTOOut createOne(PlaylistDTO playlist) {
        try {
            List<SongEntity> songs = songRepository.findAllById(playlist.getSongsId());

            PlaylistEntity entity = IPlaylistMapper.INSTANCE.toEntity(playlist);
            entity.setSongs(songs);
            playlistRepository.save(entity);

            entityManager.detach(entity);

            return IPlaylistMapper.INSTANCE.entityToDTO(findEntity(entity.getId()));
        } catch (Exception e) {
            throw new ObjectNotFoundExcept("for song ");
        }
    }

    @Override
    public List<PlaylistListDTOOut> findAll() {
        return playlistRepository.findAll().stream().map(IPlaylistMapper.INSTANCE::entitiesToListDTO).toList();
    }

    @Override
    public PlaylistInfoDTO findByID(Long id) {
        return IPlaylistMapper.INSTANCE.entityToInfoDTO(findEntity(id));
    }

    private PlaylistEntity findEntity(Long id) {
        return playlistRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcept("for playlist: " + id));
    }

    @Override
    public PlaylistDTOOut updatePlaylist(Long id, PlaylistDTO playlistEntity) {
        PlaylistEntity entity = findEntity(id);

        if (StringUtils.hasText(playlistEntity.getName())) {
            entity.setName(playlistEntity.getName());
        }

        if (StringUtils.hasText(playlistEntity.getDescription())) {
            entity.setDescription(playlistEntity.getDescription());
        }

        if (playlistEntity.getSongsId() != null && playlistEntity.getSongsId().size() > 0) {
            List<Long> ids = playlistEntity.getSongsId();
            ids.addAll(entity.getSongsId());

            List<SongEntity> songs = songRepository.findAllById(ids);
            entity.setSongs(songs);
        }

        playlistRepository.save(entity);

        return IPlaylistMapper.INSTANCE.entityToDTO(findEntity(id));
    }

    @Override
    public void deletePlaylist(Long id) {
        findEntity(id);
        playlistRepository.deleteById(id);
    }
}
