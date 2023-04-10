package com.example.book.service;

import com.example.book.model.Book;

import java.util.List;

public interface IBookService {
    Book findById(int id);
    List<Book> findAll();
    void borrow(int id, int idBorrower);
    void returnBook(Book book);
}
