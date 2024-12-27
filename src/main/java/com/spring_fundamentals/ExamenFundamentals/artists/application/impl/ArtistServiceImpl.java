package com.spring_fundamentals.ExamenFundamentals.artists.application.impl;

import com.spring_fundamentals.ExamenFundamentals.artists.application.IArtistService;
import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.IArtistMapper;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.ArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.input.UpdateArtistDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.dto.output.ArtistGenreDTO;
import com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.repository.IArtistRepository;
import com.spring_fundamentals.ExamenFundamentals.exception.AlreadyExistsException;
import com.spring_fundamentals.ExamenFundamentals.exception.ObjectNotFoundExcept;
import com.spring_fundamentals.ExamenFundamentals.genres.application.IGenreService;
import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.repository.IGenreRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    private IArtistRepository artistRepository;

    @Autowired
    private IGenreService genreService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public ArtistDTOOut createOne(ArtistDTO artist) {
        if (artistRepository.existsByName(artist.getName()))
            throw new AlreadyExistsException("for artist: " + artist.getName());

        ArtistEntity entity = IArtistMapper.INSTANCE.toEntity(artist);

        try {
            artistRepository.save(entity);

            entityManager.detach(entity);

            return IArtistMapper.INSTANCE.artistEntityToArtistDTO(findEntity(entity.getId()));
        } catch (Exception exception) {
            throw new ObjectNotFoundExcept("for genre: " + artist.getGenreId());
        }
    }

    @Override
    public List<ArtistGenreDTO> getAllArtists() {
        return artistRepository.findAll().stream().map(IArtistMapper.INSTANCE::artistListDTO).toList();
    }

    @Override
    public ArtistGenreDTO getArtistByID(Long id) {
        return IArtistMapper.INSTANCE.artistToInfoDTO(this.findEntity(id));
    }

    private ArtistEntity findEntity(Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcept("for artist: " + id));
    }

    @Override
    public ArtistDTOOut updateArtist(Long id, UpdateArtistDTO artist) {

        ArtistEntity oldArtist = this.findEntity(id);

        if (StringUtils.hasText(artist.getNewName())) {
            oldArtist.setName(artist.getNewName());
        }

        if (artist.getNewGenreId() != null && artist.getNewGenreId() >= 1) {
            genreService.getGenreById(artist.getNewGenreId());
            oldArtist.setGenreId(artist.getNewGenreId());
        }

        artistRepository.save(oldArtist);

        return IArtistMapper.INSTANCE.artistEntityToArtistDTO(findEntity(id));
    }

    @Override
    public void deleteArtist(Long id) {
        findEntity(id);
        artistRepository.deleteById(id);
    }
}
