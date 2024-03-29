package com.example.sandwich_condiments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("save")
public class SandwichCondimentsController {
    @GetMapping("")
    public String save(@RequestParam(required = false) String [] condiments, Model model ){
        if(condiments==null){
            model.addAttribute("condimentsList","");
            return "list";
        }
        model.addAttribute("condimentsList", Arrays.toString(condiments));
        return "list";
    }


}
