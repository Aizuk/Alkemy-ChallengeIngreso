package com.alkemy.challengeingreso.challengeingreso.service;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;

import java.util.List;

public interface ChracterService {

    ChracterDTO save(ChracterDTO dto);

    List<ChracterBasicDTO> getAllChracterBasic();
}
