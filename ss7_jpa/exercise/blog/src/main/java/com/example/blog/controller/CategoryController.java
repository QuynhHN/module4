package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@RequestMapping("/category")
@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public ResponseEntity<List<Category>> showListCategory(@RequestParam(required = false, defaultValue = "") String nameCategory) {
        List<Category> categoryList = iCategoryService.findByNameCategoryContaining(nameCategory);
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id) {
        iCategoryService.findAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("")
//    public String showListCategory(@RequestParam(required = false, defaultValue = "") String nameCategory, Model model) {
//        model.addAttribute("nameCategory", nameCategory);
//        model.addAttribute("categoryList", iCategoryService.findByNameCategoryContaining(nameCategory));
//        return "/category";
//    }

//    @GetMapping("/detail-category/{idCategory}")
//    public String showDetail(@PathVariable int idCategory, Model model) {
//        model.addAttribute("blog",iBlogService.findAll());
//        model.addAttribute("category", iCategoryService.findById(idCategory));
//        return "detail-category";
//    }

    @GetMapping("/create-category")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("/create-category")
    public String performCreateCategory(@ModelAttribute Category category) {
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
