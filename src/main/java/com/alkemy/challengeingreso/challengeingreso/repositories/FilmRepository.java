package com.alkemy.challengeingreso.challengeingreso.repositories;

import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {

    List<FilmEntity> findAll(Specification<FilmEntity> spec);
}
