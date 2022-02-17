package com.alkemy.challengeingreso.challengeingreso.mappers;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

    @Autowired
    private ChracterMapper chracterMapper;

    public FilmEntity filmDTO2Entity(FilmDTO dto){
        FilmEntity entity = new FilmEntity();
        entity.setImage(dto.get);
    }
}
