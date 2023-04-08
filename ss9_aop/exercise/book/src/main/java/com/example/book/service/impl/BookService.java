package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }
}
