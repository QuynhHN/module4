package com.example.product_manage.controller;

import com.example.product_manage.model.Product;
import com.example.product_manage.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String showProductList(@RequestParam(required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("productList", iProductService.listProductByName(name));
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String performCreate(@ModelAttribute Product product) {
        iProductService.createProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Product product, RedirectAttributes redirect, Model model) {
        iProductService.updateProduct(product.getId(), product);
        model.addAttribute("product", product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String performDelete(@RequestParam int deleteId) {
        iProductService.deleteProduct(deleteId);
        return "redirect:/product";
    }
}
