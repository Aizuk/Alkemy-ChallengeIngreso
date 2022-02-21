package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.FilmMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.FilmRepository;
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

    public FilmDTO save(FilmDTO dto){
        FilmEntity entity = filmMapper.filmDTO2Entity(dto);
        entity.getGenre().setId(dto.getId());
        FilmEntity filmSaved = filmRepository.save(entity);
        return filmMapper.filmEntity2DTO(filmSaved, false);
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
}
