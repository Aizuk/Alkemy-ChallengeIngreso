package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmFiltersDTO {
    private String title;
    private Long genreId;
    private String order;

    public FilmFiltersDTO (String title, Long genreId, String order){
        this.title = title;
        this.genreId = genreId;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}
