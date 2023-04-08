package com.example.book.repository;

import com.example.book.model.BookCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookCodeRepository extends JpaRepository<BookCode,Integer> {
    List<BookCode> findAll();
    BookCode findById(int idBookCode);

}
