package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmailAddress(String emailAddress);

    Optional<User> findByUsername (String username);


}
