package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.GenreDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.GenreEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.GenreMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.GenreRepository;
import com.alkemy.challengeingreso.challengeingreso.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreMapper genreMapper;
    @Autowired
    private GenreRepository genreRepository;

    public GenreDTO save(GenreDTO dto){
        GenreEntity entity = genreMapper.genreDTO2Entity(dto);
        GenreEntity genreSaved = genreRepository.save(entity);
        return genreMapper.genreEntity2DTO(genreSaved);
    }

    public List<GenreDTO> getAllGenres() {
        List<GenreEntity> entities = genreRepository.findAll();
        return genreMapper.genreEntity2DTOList(entities);
    }

    public GenreDTO update(Long id, GenreDTO genreDTO){
            GenreEntity entity = genreMapper.genreDTO2Entity(genreDTO);
            entity.setId(id);
            GenreEntity genreUpdated = genreRepository.saveAndFlush(entity);
        return genreMapper.genreEntity2DTO(entity);
    }

    public GenreEntity retrieve(GenreDTO dto){
        return genreRepository.getById(dto.getId());
    }
}
