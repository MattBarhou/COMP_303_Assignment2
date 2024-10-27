package com.example.comp_303_lab2;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Display all users
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("students", userRepository.findAll());
        return "users-list";
    }

    // Show the edit form for a specific user
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Student> student = userRepository.findById(id);
        if (student.isPresent()) {
            model.addAttribute("student", student.get());
            return "edit-user";
        } else {
            return "redirect:/";
        }
    }

    // Handle the update submission
    @PostMapping("/update/{id}")
    public String updateUser(
            @PathVariable Integer id,
            @Valid
            @ModelAttribute Student student,
            BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "edit-user";  // Return to the form if validation fails
        }

        student.setStudentID(id);
        userRepository.save(student);  // Save the updated user

        redirectAttributes.addFlashAttribute("message", "User details updated successfully!");
        return "redirect:/users";
    }
}