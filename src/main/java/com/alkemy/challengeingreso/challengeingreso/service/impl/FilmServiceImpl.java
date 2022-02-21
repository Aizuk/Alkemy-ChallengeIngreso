package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.FilmMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.FilmRepository;
import com.alkemy.challengeingreso.challengeingreso.service.FilmService;
import com.alkemy.challengeingreso.challengeingreso.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
