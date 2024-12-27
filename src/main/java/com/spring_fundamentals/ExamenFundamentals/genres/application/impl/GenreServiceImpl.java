package com.spring_fundamentals.ExamenFundamentals.genres.application.impl;

import com.spring_fundamentals.ExamenFundamentals.exception.AlreadyExistsException;
import com.spring_fundamentals.ExamenFundamentals.exception.ObjectNotFoundExcept;
import com.spring_fundamentals.ExamenFundamentals.genres.application.IGenreService;
import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.IGenreMapper;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.GenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.input.UpdateGenreDTO;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreAndArtistDTOOut;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.dto.output.GenreDTOOut;
import com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements IGenreService {

    @Autowired
    private IGenreRepository genreRepository;

    @Override
    public GenreDTOOut create(GenreDTO genre) {

        if (genreRepository.existsByName(genre.getName())) throw new AlreadyExistsException(genre.getName());

        return IGenreMapper.INSTANCE.genreToGenreDTOOut(genreRepository.save(IGenreMapper.INSTANCE.DTOToEntity(genre)));
    }

    @Override
    public List<GenreDTOOut> getAll() {
        return genreRepository.findAll().stream().map(IGenreMapper.INSTANCE::genreToGenreDTOOut).toList();
    }

    @Override
    public GenreAndArtistDTOOut getGenreById(Long id) {
        return IGenreMapper.INSTANCE.genreToGenreAndArtistDTO(findEntity(id));
    }

    private GenreEntity findEntity(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExcept("for genre:" + id.toString()));
    }

    @Override
    public UpdateGenreDTO updateGenre(Long id, UpdateGenreDTO genre) {

        GenreEntity oldGenre = this.findEntity(id);

        if (StringUtils.hasText(genre.getNewName())) {
            oldGenre.setName(genre.getNewName());
        }

        if (StringUtils.hasText(genre.getNewDescription())) {
            oldGenre.setDescription(genre.getNewDescription());
        }

        genreRepository.save(oldGenre);
        return IGenreMapper.INSTANCE.genreToGenreUpdateDTO(oldGenre);
    }

    @Override
    public void deleteById(Long id) {
        findEntity(id);

        genreRepository.deleteById(id);
    }

}
