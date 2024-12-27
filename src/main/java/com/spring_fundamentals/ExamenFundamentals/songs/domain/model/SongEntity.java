package com.spring_fundamentals.ExamenFundamentals.songs.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import com.spring_fundamentals.ExamenFundamentals.playlists.domain.model.PlaylistEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Song")
@Table(name = "songs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SongEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private double duration;

    @Column(name = "album_id")
    @JsonProperty(value = "album_id")
    private Long albumId;

    @ManyToOne
    @JoinColumn(name = "album_id", insertable = false, updatable = false)
    private AlbumEntity album;

    @ManyToMany(mappedBy = "songs")
    private List<PlaylistEntity> playlists;

    @Override
    public String toString() {
        return "SongEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", albumId=" + albumId +
                ", album=" + album +
                ", playlists=" + playlists +
                '}';
    }
}
