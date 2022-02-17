package com.alkemy.challengeingreso.challengeingreso.service.impl;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import com.alkemy.challengeingreso.challengeingreso.mappers.ChracterMapper;
import com.alkemy.challengeingreso.challengeingreso.repositories.ChracterRepository;
import com.alkemy.challengeingreso.challengeingreso.service.ChracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChracterServiceImpl implements ChracterService {

    @Autowired
    private ChracterMapper chracterMapper;
    @Autowired
    private ChracterRepository chracterRepository;

    public ChracterDTO save(ChracterDTO dto){
        ChracterEntity entity = chracterMapper;
    }
}
