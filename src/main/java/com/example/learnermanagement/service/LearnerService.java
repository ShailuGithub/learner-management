package com.example.learnermanagement.service;

import com.example.learnermanagement.dto.LearnerRequest;
import com.example.learnermanagement.dto.LearnerResponse;
import com.example.learnermanagement.entity.Learner;
import com.example.learnermanagement.exception.LearnerNotFoundException;
import com.example.learnermanagement.repository.LearnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerService {

    private final LearnerRepository learnerRepository;

    public LearnerService(LearnerRepository learnerRepository) {
        this.learnerRepository = learnerRepository;
    }

    // CREATE
    public LearnerResponse createLearner(LearnerRequest request) {

        Learner learner = new Learner();

        learner.setFirstName(request.getFirstName());
        learner.setLastName(request.getLastName());
        learner.setEmail(request.getEmail());
        learner.setPhone(request.getPhone());
        learner.setCourse(request.getCourse());
        learner.setStatus(request.getStatus());

        Learner savedLearner = learnerRepository.save(learner);

        return convertToResponse(savedLearner);
    }

    // GET ALL
    public List<LearnerResponse> getAllLearners() {

        return learnerRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // GET BY ID
    public LearnerResponse getLearnerById(Long id) {

        Learner learner = learnerRepository.findById(id)
                .orElseThrow(() -> new LearnerNotFoundException(id));

        return convertToResponse(learner);
    }

    // UPDATE
    public LearnerResponse updateLearner(
            Long id,
            LearnerRequest request) {

        Learner existingLearner = learnerRepository.findById(id)
                .orElseThrow(() -> new LearnerNotFoundException(id));

        existingLearner.setFirstName(request.getFirstName());
        existingLearner.setLastName(request.getLastName());
        existingLearner.setEmail(request.getEmail());
        existingLearner.setPhone(request.getPhone());
        existingLearner.setCourse(request.getCourse());
        existingLearner.setStatus(request.getStatus());

        Learner updatedLearner =
                learnerRepository.save(existingLearner);

        return convertToResponse(updatedLearner);
    }

    // DELETE
    public void deleteLearner(Long id) {

        Learner learner = learnerRepository.findById(id)
                .orElseThrow(() -> new LearnerNotFoundException(id));

        learnerRepository.delete(learner);
    }

    // ENTITY → RESPONSE DTO
    private LearnerResponse convertToResponse(Learner learner) {

        return new LearnerResponse(
                learner.getId(),
                learner.getFirstName(),
                learner.getLastName(),
                learner.getEmail(),
                learner.getPhone(),
                learner.getCourse(),
                learner.getStatus()
        );
    }
}