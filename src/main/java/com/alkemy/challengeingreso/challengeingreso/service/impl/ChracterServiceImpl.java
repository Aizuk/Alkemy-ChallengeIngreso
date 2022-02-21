package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.ChracterMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.ChracterRepository;
import com.alkemy.challengeingreso.challengeingreso.service.ChracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChracterServiceImpl implements ChracterService {

    @Autowired
    private ChracterMapper chracterMapper;
    @Autowired
    private ChracterRepository chracterRepository;

    public ChracterDTO save(ChracterDTO dto){
        ChracterEntity entity = chracterMapper.chracterDTO2Entity(dto);
        ChracterEntity chracterSaved = chracterRepository.save(entity);
        return chracterMapper.chracterEntity2DTO(chracterSaved, false);
    }

    @Override
    public List<ChracterBasicDTO> getAllChracterBasic() {
        List<ChracterEntity> entities = chracterRepository.findAll();
        return chracterMapper.chracterEntityList2BasicDTOList(entities);
    }

    public ChracterDTO update(Long id, ChracterDTO dto){
        ChracterEntity entity = chracterMapper.chracterDTO2Entity(dto);
        entity.setId(id);
        ChracterEntity chracterUpdated = chracterRepository.saveAndFlush(entity);
        return chracterMapper.chracterEntity2DTO(chracterUpdated, false);
    }

    public void delete(Long id){
        this.chracterRepository.deleteById(id);
    }

    public ChracterDTO getChracter(Long id){
        ChracterEntity entity = chracterRepository.getById(id);
        return chracterMapper.chracterEntity2DTO(entity, true);
    }
}
