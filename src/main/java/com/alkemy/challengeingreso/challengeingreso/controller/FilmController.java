package com.alkemy.challengeingreso.challengeingreso.controller;

import com.alkemy.challengeingreso.challengeingreso.dto.ChracterBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.ChracterDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmBasicDTO;
import com.alkemy.challengeingreso.challengeingreso.dto.FilmDTO;
import com.alkemy.challengeingreso.challengeingreso.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @PostMapping
    public ResponseEntity<FilmDTO> save(@RequestBody FilmDTO film){
        FilmDTO filmSaved = filmService.save(film);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable Long id){
        FilmDTO detailedFilm = filmService.getFilm(id);
        return ResponseEntity.ok().body(detailedFilm);
    }

    @GetMapping
    public ResponseEntity<List<FilmBasicDTO>> getAllBasic(){
        List<FilmBasicDTO> dtos = filmService.getAllFilmBasic();
        return ResponseEntity.ok().body(dtos);
    }

    /*@GetMapping
    public ResponseEntity<List<FilmBasicDTO>> getFilmByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long genreId,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<FilmBasicDTO> films = this.filmService.getFilmByFilters(name, genreId, order);
        return ResponseEntity.ok(films);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.filmService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> update(@PathVariable Long id, @RequestBody FilmDTO film){
        FilmDTO filmUpdated = filmService.update(id, film);
        return ResponseEntity.ok().body(filmUpdated);
    }
}
