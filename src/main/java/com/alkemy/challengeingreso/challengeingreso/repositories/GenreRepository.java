package com.alkemy.challengeingreso.challengeingreso.repositories;

import com.alkemy.challengeingreso.challengeingreso.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<GenreEntity, Long> {


}
