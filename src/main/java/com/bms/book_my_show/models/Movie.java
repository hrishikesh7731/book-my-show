package com.bms.book_my_show.models;

import com.bms.book_my_show.enums.MovieLanguage;
import com.bms.book_my_show.enums.MovieStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movie extends GlobalRecord {

    @Column(nullable = false, unique = true)
    private String movieCode;

    @Column(nullable = false)
    private String title;

    private String originalTitle;

    @Column(length = 2000)
    private String synopsis;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieLanguage language;

    private String genre;

    private Integer durationMinutes;

    private LocalDate releaseDate;

    private String censorCertificate;

    private String director;

    private String producer;

    private String castMembers;

    private String musicDirector;

    private String productionHouse;

    private String country;

    private String trailerUrl;

    private String posterUrl;

    private String bannerUrl;

    private Double imdbRating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieStatus status;

    @Column(nullable = false)
    private boolean active = true;
}
