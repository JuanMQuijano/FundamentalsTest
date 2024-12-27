package com.spring_fundamentals.ExamenFundamentals.playlists.domain.model;

import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity(name = "playlist")
@Table(name = "playlists")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    private List<Long> songsId;

    @ManyToMany
    @JoinTable(
            name = "playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<SongEntity> songs;

}
