package com.example.comp_303_lab2;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EnrollmentController {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentController(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    // Display enrollment form
    @GetMapping("/enrollment")
    public String enrollment(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        return "enrollment";
    }

    //Handle enrollment submission
    @PostMapping("/enrollment")
    public String enrollmentSubmission(@Valid @ModelAttribute Enrollment enrollment, BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "enrollment";
        }

        enrollmentRepository.save(enrollment);
        redirectAttributes.addFlashAttribute("message", "Enrollment successful!");
        return "redirect:/enrollment";
    }
}
