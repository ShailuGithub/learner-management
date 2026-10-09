package com.example.learnermanagement.controller;

import com.example.learnermanagement.dto.LearnerRequest;
import com.example.learnermanagement.dto.LearnerResponse;
import com.example.learnermanagement.service.LearnerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learners")
public class LearnerController {

    private final LearnerService learnerService;

    public LearnerController(LearnerService learnerService) {
        this.learnerService = learnerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LearnerResponse createLearner(
            @Valid @RequestBody LearnerRequest request) {

        return learnerService.createLearner(request);
    }

    @GetMapping
    public List<LearnerResponse> getAllLearners() {

        return learnerService.getAllLearners();
    }

    @GetMapping("/{id}")
    public LearnerResponse getLearnerById(
            @PathVariable Long id) {

        return learnerService.getLearnerById(id);
    }

    @PutMapping("/{id}")
    public LearnerResponse updateLearner(
            @PathVariable Long id,
            @Valid @RequestBody LearnerRequest request) {

        return learnerService.updateLearner(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLearner(@PathVariable Long id) {

        learnerService.deleteLearner(id);
    }
}