package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;

import java.util.List;

public interface ChracterService {

    ChracterDTO save(ChracterDTO dto);

    List<ChracterBasicDTO> getAllChracterBasic();

    ChracterDTO update(Long id, ChracterDTO dto);

    void delete(Long id);

    ChracterDTO getChracter(Long id);

    List<ChracterDTO> getByFilters(String name,Integer age,Long filmId);
}
