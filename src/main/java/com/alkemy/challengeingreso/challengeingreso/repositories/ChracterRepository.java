package com.alkemy.challengeingreso.challengeingreso.repositories;

import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChracterRepository extends JpaRepository<ChracterEntity, Long> {

}
