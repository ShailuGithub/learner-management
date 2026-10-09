package com.example.learnermanagement.exception;

public class LearnerNotFoundException extends RuntimeException {


    public LearnerNotFoundException(Long id) {
        super("Learner not found with id: " + id);
    }
}
