package com.alkemy.challengeingreso.challengeingreso.mappers;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ChracterMapper {

    @Autowired
    private FilmMapper filmMapper;

    public ChracterEntity chracterDTO2Entity(ChracterDTO dto){
        ChracterEntity entity = new ChracterEntity();
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setStory(dto.getStory());
        return entity;
    }

    public ChracterDTO chracterEntity2DTO(ChracterEntity entity, boolean loadFilms){
        ChracterDTO dto = new ChracterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setStory(dto.getStory());
        if (loadFilms) {
            List<FilmDTO> filmsDTO = this.filmMapper.filmEntityList2DTOList(entity.getFilms(), false);
            dto.setFilms(filmsDTO);
        }
        return dto;
    }

    public Set<ChracterEntity> chracterDTOList2Entity(List<ChracterDTO> dtos){
        Set<ChracterEntity> entities = new HashSet<>();
        for (ChracterDTO dto: dtos) {
            entities.add(this.chracterDTO2Entity(dto));
        }
        return entities;
    }

    public List<ChracterDTO> chracterEntityList2DTOList(List<ChracterEntity> entities, boolean loadFilms){
        List<ChracterDTO> dtos = new ArrayList<>();
        for (ChracterEntity entity: entities) {
            dtos.add(this.chracterEntity2DTO(entity, loadFilms));
        }
        return dtos;
    }

    public ChracterBasicDTO chracterEntity2BasicDTO(ChracterEntity entity){
        ChracterBasicDTO dto = new ChracterBasicDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }
}
