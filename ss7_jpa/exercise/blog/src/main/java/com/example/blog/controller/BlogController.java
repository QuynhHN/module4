package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    @Qualifier("blogService")
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("dateSubmitted").descending();
        model.addAttribute("title", title);
        model.addAttribute("blogList", iBlogService.findAll(title, PageRequest.of(page, 5, sort)));
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", iBlogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam(required = false) Integer deleteId) {
        iBlogService.delete(deleteId);
        return "redirect:/blog";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("blog", iBlogService.findById(id));
        return "/detail";
    }
}
