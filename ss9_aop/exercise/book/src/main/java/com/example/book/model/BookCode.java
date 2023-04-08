package com.example.book.model;

import javax.persistence.*;

@Entity(name = "bookCode")
@Table(name = "bookCode")
public class BookCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_code")
    private Integer idBookCode;

    @Column(unique = true)
    private Integer bookCode;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn (name = "idBorrower")
    private Borrower borrower;

    public BookCode() {
    }

    public BookCode(Integer idBookCode, Integer bookCode, Book book, Borrower borrower) {
        this.idBookCode = idBookCode;
        this.bookCode = bookCode;
        this.book = book;
        this.borrower = borrower;
    }

    public Integer getIdBookCode() {
        return idBookCode;
    }

    public void setIdBookCode(Integer idBookCode) {
        this.idBookCode = idBookCode;
    }

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}

