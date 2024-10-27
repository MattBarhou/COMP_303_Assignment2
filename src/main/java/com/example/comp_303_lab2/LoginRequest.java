package com.example.comp_303_lab2;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class LoginRequest {

    @NotNull(message = "Student ID is required")
    @Positive(message = "Student ID must be a positive number")
    private Integer studentID;

    @NotNull(message = "Password is required")
    private String password;

    // Getters and setters
    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
