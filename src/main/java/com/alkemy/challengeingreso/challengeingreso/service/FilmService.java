package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;

import java.util.List;

public interface FilmService {

    FilmDTO save(FilmDTO film);

    FilmDTO getFilm(Long id);

    List<FilmBasicDTO> getAllFilmBasic();

    void delete(Long id);

    FilmDTO update(Long id, FilmDTO dto);

    List<FilmBasicDTO> getFilmByFilters(String name, Long genreId, String order);
}
