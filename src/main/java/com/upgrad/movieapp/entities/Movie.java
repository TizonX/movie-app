package com.upgrad.movieapp.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;
@Column(length = 50, nullable = false,unique = true)
    private String movieName;
    @Column(name = "movie_esc", nullable = false, length = 500)
    private String movieDiscription;
    @Column(nullable = false)
    private LocalDateTime releaseDate;
    @Column(nullable = false)
    private int duration;
    @Column(nullable = false, length = 500)
    private String coverPhotoUrl;

    @Column(length = 500, nullable = false)
    private String trailerUrl;

}
