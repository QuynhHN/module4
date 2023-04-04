package com.example.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "blog")

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title", columnDefinition = "VARCHAR(100)", nullable = false)
    private String title;
    @Column(name = "author", columnDefinition = "VARCHAR(100)")
    private String author;
    @Column(name = "date_submitted", columnDefinition = "DATE")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd")
    private LocalDate dateSubmitted;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, String author, LocalDate dateSubmitted, String content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateSubmitted = dateSubmitted;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDate dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
