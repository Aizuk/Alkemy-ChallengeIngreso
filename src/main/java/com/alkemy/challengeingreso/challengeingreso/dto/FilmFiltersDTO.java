package com.alkemy.challengeingreso.challengeingreso.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmFiltersDTO {
    private String name;
    private Long id;
    private String order;

    public FilmFiltersDTO (String name, Long id, String order){
        this.name = name;
        this.id = id;
        this.order = order;
    }

    public boolean isASC(){
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}
