package com.spring_fundamentals.ExamenFundamentals.playlists.infrastructure.repository;

import com.spring_fundamentals.ExamenFundamentals.playlists.domain.model.PlaylistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<PlaylistEntity, Long> {
}
