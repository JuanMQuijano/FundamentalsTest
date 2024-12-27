package com.spring_fundamentals.ExamenFundamentals.artists.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring_fundamentals.ExamenFundamentals.albums.domain.model.AlbumEntity;
import com.spring_fundamentals.ExamenFundamentals.genres.domain.model.GenreEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Artist")
@Table(name = "artist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArtistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "genre_id")
    @JsonProperty(value = "genre_id")
    private Long genreId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private GenreEntity genre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "artist", cascade = CascadeType.REMOVE)
    private List<AlbumEntity> albums;
}
