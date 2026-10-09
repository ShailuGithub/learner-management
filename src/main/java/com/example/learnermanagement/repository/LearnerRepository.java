package com.example.learnermanagement.repository;

import com.example.learnermanagement.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner,Long> {
}
