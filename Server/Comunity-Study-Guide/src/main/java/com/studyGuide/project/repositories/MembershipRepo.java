package com.studyGuide.project.repositories;

import com.studyGuide.project.entitys.EnrollmentId;
import com.studyGuide.project.entitys.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, EnrollmentId> {
}
