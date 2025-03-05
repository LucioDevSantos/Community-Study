package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.SecurityToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<SecurityToken, Long> {

    Optional<SecurityToken> findByToken(String token);
    Optional<SecurityToken> findByEmailAddress(String emailAddress);
}
