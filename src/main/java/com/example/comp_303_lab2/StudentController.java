package com.example.comp_303_lab2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    //Display the index page
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", new Student());
        return "index";
    }

    //Handle the form submission then redirect to program page
    @PostMapping("/")
    public String index(@Valid @ModelAttribute Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        //Check if student ID already exists
        if (studentRepository.existsById(student.getStudentID())) {
            model.addAttribute("error", "Student ID already exists");
            return "index";
        }

        studentRepository.save(student); //Save the student to the database
        return "redirect:/program";
    }

}
