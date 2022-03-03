package com.alkemy.challengeingreso.challengeingreso.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chracter")
@Getter
@Setter
@SQLDelete(sql = "UPDATE chracter SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ChracterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;

    private String name;

    private Integer age;

    private Integer weight;

    private String story;

    @ManyToMany(mappedBy = "chracters", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<FilmEntity> films = new ArrayList<>();

    private Boolean deleted = Boolean.FALSE;

    public void addFilm(FilmEntity film){
        this.films.add((film));
    }

    public void removeFilm(FilmEntity film){
        this.films.remove(film);
    }

}
