package com.spring_fundamentals.ExamenFundamentals.artists.infrastructure.repository;

import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArtistRepository extends JpaRepository<ArtistEntity, Long> {

    boolean existsByName(String name);

}
