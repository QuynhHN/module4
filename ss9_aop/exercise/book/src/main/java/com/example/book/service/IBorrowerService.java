package com.example.book.service;

import com.example.book.model.Borrower;

import java.util.List;

public interface IBorrowerService {
    List<Borrower> findAll();
    Borrower findById(int idBorrower);
}
