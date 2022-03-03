package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.GenreDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.GenreEntity;

import java.util.List;

public interface GenreService {

    GenreDTO save(GenreDTO dto);

    List<GenreDTO> getAllGenres();

    GenreDTO update(Long id, GenreDTO dto);

    GenreEntity retrieveOrMap(GenreDTO dto);
}
