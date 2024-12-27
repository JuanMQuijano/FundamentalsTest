package com.spring_fundamentals.ExamenFundamentals.genres.infrastructure.repository;

import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<GenreEntity, Long> {

    boolean existsByName(String name);

}
