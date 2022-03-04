package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;

import java.util.List;

public interface FilmService {

    FilmDTO save(FilmDTO film);

    FilmDTO getFilm(Long id);

    List<FilmBasicDTO> getAllFilmBasic();

    void delete(Long id);

    FilmDTO update(Long id, FilmDTO dto);

    List<FilmBasicDTO> getFilmByFilters(String title, Long genreId, String order);

    FilmEntity getFilmEntity(Long id);

    FilmEntity retrieve(FilmDTO dto);

    List<FilmEntity> retrieveOrMapDTOList2EntityList(List<FilmDTO> dtos);

    FilmEntity retrieveOrMapDTO2Entity(FilmDTO dto);
}
