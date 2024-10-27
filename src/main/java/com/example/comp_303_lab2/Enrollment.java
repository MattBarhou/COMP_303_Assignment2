package com.example.comp_303_lab2;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    //Declare all the necessary properties
    @Id
    @Column(name = "applicationNo")
    @NotNull(message = "Application number is required")
    @Min(value = 1, message = "Application number must be greater than 0")
    private Integer applicationNo;

    @Column(name = "studentId")
    @NotNull(message = "Student ID is required")
    @Min(value = 1, message = "Student ID must be greater than 0")
    private Integer studentId;

    @Column(name = "programCode")
    @NotBlank(message = "Program code is required")
    @Size(max = 10, message = "Program code must not exceed 10 characters")
    private String programCode;

    @Column(name = "startDate")
    @NotNull(message = "Start date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")  // Add this annotation
    @Temporal(TemporalType.DATE)
    @FutureOrPresent(message = "Start date must be today or in the future")
    private Date startDate;

    @Column(name = "amountPaid")
    @NotNull(message = "Amount paid is required")
    @PositiveOrZero(message = "Amount paid must be zero or positive")
    private Float amountPaid;

    //Declare the default constructor
    public Enrollment() {
    }

    //Declare the parameterized constructor
    public Enrollment(Integer applicationNo, Integer studentId, String programCode, Date startDate, Float amountPaid) {
        this.applicationNo = applicationNo;
        this.studentId = studentId;
        this.programCode = programCode;
        this.startDate = startDate;
        this.amountPaid = amountPaid;
    }

    //Declare all getters and setters
    public Integer getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(Integer applicationNo) {
        this.applicationNo = applicationNo;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getProgramCode() {
        return programCode;
    }

    public void setProgramCode(String programCode) {
        this.programCode = programCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Float amountPaid) {
        this.amountPaid = amountPaid;
    }

}
