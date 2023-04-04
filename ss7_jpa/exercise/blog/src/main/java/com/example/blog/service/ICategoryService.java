package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findByNameCategoryContaining(String nameCategory);
    void save(Category category);
    List<Category> findAll();
    Category findById(int idCategory);
    void delete(int idCategory);
}
