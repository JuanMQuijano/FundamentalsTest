package com.spring_fundamentals.ExamenFundamentals.genres.domain.model;

import com.spring_fundamentals.ExamenFundamentals.artists.domain.model.ArtistEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Genre")
@Table(name = "genres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "genre", cascade = CascadeType.REMOVE)
    private List<ArtistEntity> artists;

}
