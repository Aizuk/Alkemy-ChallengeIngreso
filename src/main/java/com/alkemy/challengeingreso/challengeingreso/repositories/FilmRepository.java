package com.alkemy.challengeingreso.challengeingreso.repositories;

import com.alkemy.challengeingreso.challengeingreso.entities.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
}
