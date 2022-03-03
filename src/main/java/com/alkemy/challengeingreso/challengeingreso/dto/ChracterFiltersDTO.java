package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ChracterFiltersDTO {
    private String name;
    private Integer age;
    private Set<Long> filmsId;

    public ChracterFiltersDTO(String name, Integer age, Set<Long> filmId){
        this.name = name;
        this.age = age;
        this.filmsId = filmsId;
    }
}
