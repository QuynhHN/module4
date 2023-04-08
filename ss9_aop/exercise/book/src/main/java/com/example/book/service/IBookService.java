package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    Book findById(int id);
    List<Book> findAll();
}
