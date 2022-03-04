package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterFiltersDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.ChracterMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.ChracterRepository;
import com.alkemy.challengeingreso.challengeingreso.repositories.specifications.ChracterSpecification;
import com.alkemy.challengeingreso.challengeingreso.service.ChracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ChracterServiceImpl implements ChracterService {

    @Autowired
    private ChracterMapper chracterMapper;
    @Autowired
    private ChracterRepository chracterRepository;
    @Autowired
    ChracterSpecification chracterSpecification;

    public ChracterDTO save(ChracterDTO dto){
        ChracterEntity entity = chracterMapper.chracterDTO2Entity(dto);
        ChracterEntity chracterSaved = chracterRepository.save(entity);
        return chracterMapper.chracterEntity2DTO(chracterSaved, true);
    }

    @Override
    public List<ChracterBasicDTO> getAllChracterBasic() {
        List<ChracterEntity> entities = chracterRepository.findAll();
        return chracterMapper.chracterEntityList2BasicDTOList(entities);
    }

    public ChracterDTO update(Long id, ChracterDTO dto){
        ChracterEntity entity = chracterMapper.updateValues(id, dto);
        ChracterEntity chracterUpdated = chracterRepository.save(entity);
        return chracterMapper.chracterEntity2DTO(chracterUpdated, true);
    }

    public void delete(Long id){
        this.chracterRepository.deleteById(id);
    }

    public ChracterDTO getChracter(Long id){
        ChracterEntity entity = chracterRepository.getById(id);
        return chracterMapper.chracterEntity2DTO(entity, true);
    }

    public List<ChracterBasicDTO> getByFilters(String name, Integer age, Set<Long> filmsId){
        ChracterFiltersDTO filters = new ChracterFiltersDTO(name, age, filmsId);
        List<ChracterEntity> entities = this.chracterRepository.findAll(chracterSpecification.getByFilters(filters));
        List<ChracterBasicDTO> dtos = chracterMapper.chracterEntityList2BasicDTOList(entities);
        return dtos;
    }
}
