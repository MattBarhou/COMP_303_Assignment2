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
public class ProgramController {

    @Autowired
    private ProgramsRepository programRepository;

    public ProgramController(ProgramsRepository programRepository) {
        this.programRepository = programRepository;
    }


    @GetMapping("/program")
    public String program(Model model) {
        model.addAttribute("program", new Programs());
        return "program";
    }

    @PostMapping("/program")
    public String programSubmission(@Valid @ModelAttribute Programs program, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "program";
        }
        programRepository.save(program);
        return "confirmation";
    }
}
