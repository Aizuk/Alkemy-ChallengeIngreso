package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmFiltersDTO {
    private String title;
    private Long id;
    private String order;

    public FilmFiltersDTO (String title, Long id, String order){
        this.title = title;
        this.id = id;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}
