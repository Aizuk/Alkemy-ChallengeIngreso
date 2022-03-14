package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.*;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.FilmMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.FilmRepository;
import com.alkemy.challengeingreso.challengeingreso.repositories.specifications.FilmSpecification;
import com.alkemy.challengeingreso.challengeingreso.service.FilmService;
import com.alkemy.challengeingreso.challengeingreso.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private GenreService genreService;
    @Autowired
    FilmSpecification filmSpecification;

    public FilmDTO save(FilmDTO dto){
        FilmEntity entity = filmMapper.filmDTO2Entity(dto);
        entity.setGenre(genreService.retrieve(dto.getGenre()));
        FilmEntity filmSaved = filmRepository.save(entity);
        return filmMapper.filmEntity2DTO(filmSaved, true);
    }

    public FilmDTO getFilm(Long id){
        FilmEntity entity = filmRepository.getById(id);
        return filmMapper.filmEntity2DTO(entity, true);
    }

    public List<FilmBasicDTO> getAllFilmBasic(){
        List<FilmEntity> entities = filmRepository.findAll();
        return filmMapper.filmEntityList2DTOBasicList(entities);
    }

    public void delete(Long id) {
        this.filmRepository.deleteById(id);
    }

    public FilmDTO update(Long id, FilmDTO dto){
        FilmEntity entity = filmMapper.filmDTO2Entity(dto);
        entity.setId(id);
        FilmEntity filmUpdated = filmRepository.saveAndFlush(entity);
        return filmMapper.filmEntity2DTO(filmUpdated, true);
    }

    public List<FilmBasicDTO> getFilmByFilters(String title, Long genreId, String order){
        FilmFiltersDTO filters = new FilmFiltersDTO(title, genreId, order);
        List<FilmEntity> entities = this.filmRepository.findAll(filmSpecification.getByFilters(filters));
        List<FilmBasicDTO> dtos = filmMapper.filmEntityList2DTOBasicList(entities);
        return dtos;
    }

    public FilmEntity getFilmEntity(Long id) {
        return filmRepository.getById(id);
    }

    public FilmEntity retrieve(FilmDTO dto){
        Long id = dto.getId();
        FilmEntity example = filmRepository.getById(id);
        return filmRepository.getById(dto.getId());
    }

    public List<FilmEntity> retrieveOrMapDTOList2EntityList(List<FilmDTO> dtos){
        List<FilmEntity> entities = new ArrayList<>();
        for (FilmDTO dto: dtos) {
            entities.add(retrieveOrMapDTO2Entity(dto));
        }
        return entities;
    }

    public FilmEntity retrieveOrMapDTO2Entity(FilmDTO dto){
        /*if(dto.getId()!=null){
            return retrieve(dto);
        } else {
            return filmMapper.filmDTO2Entity(dto);
        }*/
        Optional<FilmEntity> entity = filmRepository.findById(dto.getId());
        if (entity.isPresent()){
            return entity.get();
        } else {
            return filmMapper.filmDTO2Entity(dto);
        }
    }
}
