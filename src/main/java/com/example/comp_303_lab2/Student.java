package com.example.comp_303_lab2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    //Declare all the necessary properties

    @Id
    @Column(name = "studentId")
    @NotNull(message = "Student ID is required")
    @Min(value = 1, message = "Student ID must be greater than 0")
    private Integer studentID;

    @Column(name = "userName")
    @NotBlank(message = "Username is required")
    @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters")
    private String userName;

    @Column(name = "password")
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Column(name = "firstname")
    @NotBlank(message = "First name is required")
    @Size(max = 30, message = "First name must not exceed 30 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotBlank(message = "Last name is required")
    @Size(max = 30, message = "Last name must not exceed 30 characters")
    private String lastName;

    @Column(name = "address")
    @NotBlank(message = "Address is required")
    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "City is required")
    @Size(max = 50, message = "City must not exceed 50 characters")
    private String city;

    @Column(name = "postalCode")
    @NotBlank(message = "Postal code is required")
    @Pattern(regexp = "^[A-Z0-9]{5,10}$", message = "Invalid postal code format")
    private String postalCode;

    @Column(name = "technicalSkills")
    @NotBlank(message = "Technical skills are required")
    @Size(max = 500, message = "Technical skills must not exceed 500 characters")
    private String technicalSkills;

    //Declare the default constructor
    public Student() {
    }

    //Declare the parameterized constructor
    public Student(Integer studentID, String userName, String password, String firstName, String lastName, String address, String city, String postalCode, String technicalSkills) {
        this.studentID = studentID;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.technicalSkills = technicalSkills;
    }

    //Declare all getters and setters

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTechnicalSkills() {
        return technicalSkills;
    }

    public void setTechnicalSkills(String technicalSkills) {
        this.technicalSkills = technicalSkills;
    }

}
