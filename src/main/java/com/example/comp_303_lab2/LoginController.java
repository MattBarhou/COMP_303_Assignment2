package com.example.comp_303_lab2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    public LoginController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Display the login page on a get request
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginRequest", new LoginRequest()); //Add the login request object to the model
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmission(@Valid @ModelAttribute LoginRequest loginRequest, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "login";
        }

        //Find the student by student ID
        Optional<Student> student1 = studentRepository.findById(loginRequest.getStudentID());

        if (student1.isPresent()) {
            Student currentStudent = student1.get();

            //Check if password matches
            if (currentStudent.getPassword().equals(loginRequest.getPassword())) {
                return "redirect:/program";
            }
            else {
                model.addAttribute("error", "Invalid password");
                return "login";
            }
        }
        else {
            model.addAttribute("error", "Invalid ID or password");
            return "login";
        }
    }
}
