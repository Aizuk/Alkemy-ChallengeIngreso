package com.alkemy.challengeingreso.challengeingreso.controller;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.service.ChracterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class ChracterController {

    @Autowired
    private ChracterService chracterService;

    @GetMapping
    public ResponseEntity<List<ChracterBasicDTO>> getAllBasic(){
        List<ChracterBasicDTO> dtos = chracterService.getAllChracterBasic();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<ChracterDTO> save(@RequestBody ChracterDTO chracter){
        ChracterDTO chracterSaved = chracterService.save(chracter);
        return ResponseEntity.status(HttpStatus.CREATED).body(chracterSaved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChracterDTO> update(@PathVariable Long id, @RequestBody ChracterDTO chracter){
        ChracterDTO chracterUpdated = chracterService.update(id, chracter);
        return ResponseEntity.ok().body(chracterUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.chracterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChracterDTO> getChracter(@PathVariable Long id){
        ChracterDTO detailedChracter = chracterService.getChracter(id);
        return ResponseEntity.ok().body(detailedChracter);
    }
}
