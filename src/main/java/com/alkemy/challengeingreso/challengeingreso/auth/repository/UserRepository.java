package com.alkemy.challengeingreso.challengeingreso.auth.repository;

import com.alkemy.challengeingreso.challengeingreso.auth.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
