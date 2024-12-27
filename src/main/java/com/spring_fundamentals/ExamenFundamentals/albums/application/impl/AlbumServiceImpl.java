package com.spring_fundamentals.ExamenFundamentals.albums.application.impl;

import com.spring_fundamentals.ExamenFundamentals.albums.application.IAlbumService;
import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.IAlbumMapper;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.input.AlbumDTO;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumDTOOut;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.dto.output.AlbumInfoDTO;
import com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.repository.IAlbumRepository;
import com.spring_fundamentals.ExamenFundamentals.artists.application.IArtistService;
import com.spring_fundamentals.ExamenFundamentals.exception.ObjectNotFoundExcept;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
    private IAlbumRepository albumRepository;

    @Autowired
    private IArtistService artistService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public AlbumDTOOut createOne(AlbumDTO album) {
        try {
            AlbumEntity entity = IAlbumMapper.INSTANCE.toEntity(album);
            albumRepository.save(entity);

            entityManager.detach(entity);

            return IAlbumMapper.INSTANCE.entityToAlbumDTOOut(findEntity(entity.getId()));
        } catch (Exception e) {
            throw new ObjectNotFoundExcept("for artist: " + album.getArtistId());
        }
    }

    @Override
    public List<AlbumDTOOut> findAll() {
        return albumRepository.findAll().stream().map(IAlbumMapper.INSTANCE::entityToAlbumDTOOut).toList();
    }

    @Override
    public AlbumInfoDTO getAlbumByID(Long id) {
        return IAlbumMapper.INSTANCE.entityToAlbumInfoDTO(findEntity(id));
    }

    private AlbumEntity findEntity(Long id) {
        return albumRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcept("for album: " + id));
    }

    @Override
    public AlbumDTOOut updateAlbum(Long id, AlbumDTO album) {
        AlbumEntity oldAlbum = findEntity(id);

        if (StringUtils.hasText(album.getName())) {
            oldAlbum.setName(album.getName());
        }

        if (StringUtils.hasText(String.valueOf(album.getReleaseDate()))) {
            oldAlbum.setReleaseDate(album.getReleaseDate());
        }

        if (album.getArtistId() != null && album.getArtistId() >= 1) {
            artistService.getArtistByID(album.getArtistId());
            oldAlbum.setArtistId(album.getArtistId());
        }

        albumRepository.save(oldAlbum);

        entityManager.detach(oldAlbum);

        return IAlbumMapper.INSTANCE.entityToAlbumDTOOut(findEntity(oldAlbum.getId()));
    }

    @Override
    public void deleteAlbum(Long id) {
        findEntity(id);
        albumRepository.deleteById(id);
    }
}
