package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    List<Category> findByNameCategoryContaining(String nameCategory);

    List<Category> findAll();

    Category findById(int idCategory);
}
