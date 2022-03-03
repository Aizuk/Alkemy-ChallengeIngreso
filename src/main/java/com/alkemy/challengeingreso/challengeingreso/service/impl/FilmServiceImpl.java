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

import java.util.List;

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
        entity.setGenre(genreService.retrieveOrMap(dto.getGenre()));
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
        return filmMapper.filmEntity2DTO(filmUpdated, false);
    }

    public List<FilmBasicDTO> getFilmByFilters(String name, Long genreId, String order){
        FilmFiltersDTO filters = new FilmFiltersDTO(name, genreId, order);
        List<FilmEntity> entities = this.filmRepository.findAll(this.filmSpecification.getByFilters(filters));
        List<FilmBasicDTO> dtos = filmMapper.filmEntityList2DTOBasicList(entities);
        return dtos;
    }
}
