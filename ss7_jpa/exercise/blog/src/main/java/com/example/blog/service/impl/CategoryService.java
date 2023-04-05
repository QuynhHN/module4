package com.example.blog.service.impl;

import com.example.blog.model.Category;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findByNameCategoryContaining(String nameCategory) {
        return iCategoryRepository.findByNameCategoryContaining(nameCategory);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Category findById(int idCategory) {
        return iCategoryRepository.findById(idCategory);
    }

    @Override
    public void delete(int idCategory) {
        iCategoryRepository.delete(findById(idCategory));
    }
}
