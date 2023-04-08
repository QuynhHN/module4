package com.example.book.service;

import com.example.book.model.BookCode;

import java.util.List;

public interface IBookCodeService {
    List<BookCode> findAll();

    BookCode findById(int idBookCode);

    void save(BookCode bookCode);

    void delete(int idBookCode);
}
