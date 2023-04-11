package com.example.blog.repository;

import com.example.blog.model.Blog;
import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Blog findById(int id);
    List<Blog> findAll();

}
