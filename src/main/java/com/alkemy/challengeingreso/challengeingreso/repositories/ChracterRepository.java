package com.alkemy.challengeingreso.challengeingreso.repositories;

import com.alkemy.challengeingreso.challengeingreso.entities.ChracterEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChracterRepository extends JpaRepository<ChracterEntity, Long> {

    List<ChracterEntity> findAll(Specification<ChracterEntity> spec);

}
