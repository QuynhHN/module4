package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll(String title);

    void save(Blog blog);


    void delete(int id);

    Blog findById(int id);
}
