package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;

public interface FilmService {

    FilmDTO save(FilmDTO film);

    FilmDTO getFilm(Long id);
}
