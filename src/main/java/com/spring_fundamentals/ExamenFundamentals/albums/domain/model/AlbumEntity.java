package com.spring_fundamentals.ExamenFundamentals.albums.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import com.spring_fundamentals.ExamenFundamentals.songs.domain.model.SongEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Album")
@Table(name = "albums")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonProperty(value = "release_date")
    @Column
    private LocalDate releaseDate;

    @Column(name = "artist_id")
    @JsonProperty(value = "artist_id")
    private Long artistId;

    @ManyToOne
    @JoinColumn(name = "artist_id", insertable = false, updatable = false)
    private ArtistEntity artist;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album", cascade = CascadeType.REMOVE)
    private List<SongEntity> songs;

}
