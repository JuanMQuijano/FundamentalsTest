package com.spring_fundamentals.ExamenFundamentals.albums.infrastructure.repository;

import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumRepository extends JpaRepository<AlbumEntity, Long> {
}
