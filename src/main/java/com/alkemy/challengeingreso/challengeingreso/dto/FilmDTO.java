package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmDTO {
    private Long id;
    private String image;
    private String title;
    private String creationDate;
    private Integer rating;
    private GenreDTO genre;
    private List<ChracterDTO> chracters;
}
