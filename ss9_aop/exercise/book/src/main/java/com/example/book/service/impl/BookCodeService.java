package com.example.book.service.impl;

import com.example.book.model.BookCode;
import com.example.book.repository.IBookCodeRepository;
import com.example.book.service.IBookCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookCodeService")
public class BookCodeService implements IBookCodeService {
    @Autowired
    private IBookCodeRepository iBookCodeRepository;

    @Override
    public List<BookCode> findAll() {
        return iBookCodeRepository.findAll();
    }

    @Override
    public BookCode findById(int idBookCode) {
        return iBookCodeRepository.findById(idBookCode);
    }

    @Override
    public void save(BookCode bookCode) {
        iBookCodeRepository.save(bookCode);
    }

    @Override
    public void delete(int idBookCode) {
        iBookCodeRepository.delete(findById(idBookCode));
    }
}
