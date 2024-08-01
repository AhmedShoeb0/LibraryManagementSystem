package com.AS.LibraryManagementSystem.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(name= "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Integer     id;
    private String      title;
    private String      author;
    private LocalDate   publication_year;
    private Long        ISBN;

    // Relationships
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrowing_record> borrowing_record = new ArrayList<>();

    //Constructors
    public Book(){
    }

   public Book(Integer id,
               String title,
               String author,
               LocalDate   publication_year,
               Long ISBN){
    this.id=id;
    this.title=title;
    this.author=author;
    this.ISBN=ISBN;
    }

    public Book(String title,
                String author,
                LocalDate   publication_year,
                Long ISBN){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
    }


    //Setters & Getters
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

    public LocalDate getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(LocalDate publication_year) {
        this.publication_year=publication_year;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }
}
