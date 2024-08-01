package com.AS.LibraryManagementSystem.Controller;

import com.AS.LibraryManagementSystem.Model.Book;
import com.AS.LibraryManagementSystem.Service.Book_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/books")
public class Book_controller {
    private final Book_Service bookService;

    @Autowired
    public Book_controller(Book_Service bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book findByID(@PathVariable Integer id){
        return bookService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void ADD(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        bookService.deleteByID(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Book book, @PathVariable Integer id){
        if(!bookService.existByID(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        bookService.updateBook(book);
    }

}
