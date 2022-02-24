package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChracterFiltersDTO {
    private String name;
    private Integer age;
    private List<FilmDTO> films;

    public ChracterFiltersDTO(String name, Integer age, List<FilmDTO> films){
        this.name = name;
        this.age = age;
        this.films = films;
    }
}
