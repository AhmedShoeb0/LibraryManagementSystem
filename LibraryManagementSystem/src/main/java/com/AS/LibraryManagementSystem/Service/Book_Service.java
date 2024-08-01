package com.AS.LibraryManagementSystem.Service;

import com.AS.LibraryManagementSystem.Model.Book;
import com.AS.LibraryManagementSystem.Repository.Book_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Book_Service {
private final Book_Repo bookRepo;

    @Autowired
    public Book_Service(Book_Repo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public final Optional<Book> findById(Integer id) {
        return bookRepo.findById(id);
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepo.findBookByISBN(book.getISBN());
        if (bookOptional.isPresent()){
            throw new IllegalStateException("This ISBN is already there.");
        }
        bookRepo.save(book);
    }

    public void deleteByID(Integer id) {
        boolean exist = bookRepo.existsById(id);
        if(!exist){
            throw new IllegalStateException("Book with id " + id + " does not exist");
        }
        bookRepo.deleteById(id);
    }

    public void updateBook(Book book) {
        bookRepo.findAll().removeIf(c -> c.getId().equals(book.getId()));
        bookRepo.save(book);
    }

    public boolean existByID(Integer id) {
            return bookRepo.findAll().stream().filter(c -> c.getId().equals(id)).count()==1;
        }

}
