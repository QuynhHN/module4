package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import com.example.dictionary.service.impl.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
private IDictionaryService iDictionaryService= new DictionaryService();
@GetMapping("")
    public String dictionary(@RequestParam(required = false) String english, Model model){
    if(english==null){
        return "list";
    }
    model.addAttribute("english",english);
    model.addAttribute("result",iDictionaryService.list(english));
    return "list";
}

}
