package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(String title, Pageable pageable);

    void save(Blog blog);

    List<Blog> findAll();
    void delete(int id);

    Blog findById(int id);
}
