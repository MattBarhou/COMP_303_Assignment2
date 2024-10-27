package com.example.comp_303_lab2;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Programs {

    //Declare all the necessary properties

    @Id
    @Column(name = "programCode")
    @NotBlank(message = "Program code is required")
    @Size(max = 10, message = "Program code must not exceed 10 characters")
    private String programCode;

    @Column(name = "programName")
    @NotBlank(message = "Program name is required")
    @Size(max = 50, message = "Program name must not exceed 50 characters")
    private String programName;

    @Column(name = "duration")
    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 month")
    private Integer duration;

    @Column(name = "fee")
    @NotNull(message = "Fee is required")
    @Positive(message = "Fee must be a positive value")
    private Float fee;

    @Column(name = "professor")
    @NotBlank(message = "Professor name is required")
    @Size(max = 50, message = "Professor name must not exceed 50 characters")
    private String professor;

    //Declare the default constructor
    public Programs() {
    }

    //Declare the parameterized constructor
    public Programs(String programCode, String programName, Integer duration, Float fee, String professor) {
        this.programCode = programCode;
        this.programName = programName;
        this.duration = duration;
        this.fee = fee;
        this.professor = professor;
    }

    //Declare all getters and setters

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

}
