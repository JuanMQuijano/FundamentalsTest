package com.spring_fundamentals.ExamenFundamentals.songs.infrastructure.repository;

import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<SongEntity, Long> {

    boolean existsByName(String name);

}
