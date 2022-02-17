package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChracterDTO {
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Integer weight;
    private String story;
    private List<FilmDTO> films;

}
