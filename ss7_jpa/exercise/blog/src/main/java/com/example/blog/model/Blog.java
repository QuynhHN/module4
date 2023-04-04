package com.example.blog.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private String dateSubmitted;
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String title, String author, String dateSubmitted, String content, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dateSubmitted = dateSubmitted;
        this.content = content;
        this.category = category;
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

    public String getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(String dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //    public String getDateSubmitted() {
//        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

//        return dtFormatter.format(dateSubmitted);
//    }

//    public void setDateSubmitted(LocalDate dateSubmitted) {
//        this.dateSubmitted = dateSubmitted;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
