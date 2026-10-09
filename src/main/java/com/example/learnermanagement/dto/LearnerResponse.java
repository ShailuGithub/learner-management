package com.example.learnermanagement.dto;

import com.example.learnermanagement.entity.LearnerStatus;

public class LearnerResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String course;
    private LearnerStatus status;

    public LearnerResponse() {
    }

    public LearnerResponse(
            Long id,
            String firstName,
            String lastName,
            String email,
            String phone,
            String course,
            LearnerStatus status) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCourse() {
        return course;
    }

    public LearnerStatus getStatus() {
        return status;
    }
}