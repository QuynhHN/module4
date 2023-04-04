package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    public String showListCategory(@RequestParam(required = false, defaultValue = "") String nameCategory, Model model) {
        model.addAttribute("nameCategory", nameCategory);
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "/category";
    }
    @GetMapping("/create-category")
    public String showCreateCategory (Model model){
        model.addAttribute("category",new Category());
        return "create-category";
    }
    @PostMapping("/create-category")
    public String performCreateCategory(@ModelAttribute Category category){
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/update-category/{idCategory}")
    public String showUpdateCategory(@PathVariable int idCategory, Model model) {
        model.addAttribute("category", iCategoryService.findById(idCategory));
        return "update-category";
    }

    @PostMapping("/update")
    public String performUpdateCategory(@ModelAttribute Category category) {
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete-category")
    public String performDeleteCategory(@RequestParam(required = false) Integer idCategoryDelete) {
        iCategoryService.delete(idCategoryDelete);
        return "redirect:/category";
    }
}
