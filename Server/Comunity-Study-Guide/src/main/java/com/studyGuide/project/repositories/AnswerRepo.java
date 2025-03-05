package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answers, Long> {
}
