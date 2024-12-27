package com.spring_fundamentals.ExamenFundamentals.songs.application.impl;

import com.spring_fundamentals.ExamenFundamentals.albums.application.IAlbumService;
import com.spring_fundamentals.ExamenFundamentals.exception.AlreadyExistsException;
import com.spring_fundamentals.ExamenFundamentals.exception.ObjectNotFoundExcept;
import com.spring_fundamentals.ExamenFundamentals.songs.application.ISongService;
import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.ISongMapper;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.input.SongDTO;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongDTOOut;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.dto.output.SongInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.repository.ISongRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository songRepository;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public SongDTOOut createOne(SongDTO songEntity) {
        try {
            SongEntity entity = ISongMapper.INSTANCE.toEntity(songEntity);
            songRepository.save(entity);

            entityManager.detach(entity);
            return ISongMapper.INSTANCE.entityToDTOOut(findEntity(entity.getId()));
        } catch (Exception e) {
            throw new ObjectNotFoundExcept("for album: " + songEntity.getAlbumId());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongDTOOut> findAll() {
        return songRepository.findAll().stream().map(ISongMapper.INSTANCE::entityToDTOOut).toList();
    }

    @Override
    public SongInfoDTO findByID(Long id) {
        return ISongMapper.INSTANCE.entityToDTOInfo(this.findEntity(id));
    }

    private SongEntity findEntity(Long id) {
        return songRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcept("for song: " + id));
    }

    @Override
    public SongDTOOut updateSong(Long id, SongDTO songEntity) {

        SongEntity entity = findEntity(id);

        if (StringUtils.hasText(songEntity.getName())) {
            entity.setName(songEntity.getName());
        }

        if (String.valueOf(songEntity.getDuration()) != null && songEntity.getDuration() > 0) {
            entity.setDuration(songEntity.getDuration());
        }

        if (songEntity.getAlbumId() != null && songEntity.getAlbumId() >= 1) {
            albumService.getAlbumByID(songEntity.getAlbumId());
            entity.setAlbumId(songEntity.getAlbumId());
        }

        songRepository.save(entity);

        return ISongMapper.INSTANCE.entityToDTOOut(findEntity(id));
    }

    @Override
    public void deleteSong(Long id) {
        findEntity(id);
        songRepository.deleteById(id);
    }
}
