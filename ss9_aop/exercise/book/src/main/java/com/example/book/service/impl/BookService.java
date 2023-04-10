package com.example.book.service.impl;

import com.example.book.model.Book;
import com.example.book.model.BookCode;
import com.example.book.model.Borrower;
import com.example.book.repository.IBookCodeRepository;
import com.example.book.repository.IBookRepository;
import com.example.book.repository.IBorrowerRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service("bookService")
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;
    @Autowired
    private IBookCodeRepository iBookCodeRepository;
    @Autowired
    private IBorrowerRepository iBorrowerRepository;

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void borrow(int id, int idBorrower) {
        Book book = iBookRepository.findById(id);
        book.setQuantity(book.getQuantity() - 1);
        int codeBook = (int) Math.floor((Math.random() * 89999) + 10000);
        Borrower borrower = iBorrowerRepository.findById(idBorrower);

        BookCode bookCode = new BookCode();
        bookCode.setBookCode(codeBook);
        bookCode.setBook(book);
        bookCode.setDayBorrow(Date.from(Instant.now()).toString());
        bookCode.setBorrower(borrower);
        iBookCodeRepository.save(bookCode);
        iBookRepository.save(book);
    }

    @Override
    public void returnBook(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);

    }
}
