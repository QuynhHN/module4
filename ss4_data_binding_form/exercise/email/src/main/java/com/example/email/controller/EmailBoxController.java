package com.example.email.controller;

import com.example.email.model.EmailBox;
import com.example.email.service.IEmailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/email")
public class EmailBoxController {
    @Autowired
    private IEmailBoxService iEmailBoxService;

    @GetMapping("")
    public String showUpdate(Model model) {
        model.addAttribute("emailBox", iEmailBoxService.emailBox());
        model.addAttribute("languagesList",iEmailBoxService.getLanguagesList() );
        model.addAttribute("pagesizesList", iEmailBoxService.getPagesizesList());
        return "update";
    }
    @PostMapping("")
    public String performUpdate(@ModelAttribute EmailBox emailBox,Model model){
        iEmailBoxService.update(emailBox);
        model.addAttribute("emailBox",emailBox);
        return "detail";
    }
}
