package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChracterFiltesrDTO {
    private String name;
    private Integer age;
    private Long filmId;

    public ChracterFiltesrDTO(String name, Integer age, Long filmId){
        this.name = name;
        this.age = age;
        this.filmId = filmId;
    }
}
