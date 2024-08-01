package com.AS.LibraryManagementSystem.Repository;

import com.AS.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Book_Repo extends JpaRepository<Book,Integer> {

    @Query("SELECT b from Book b where b.ISBN = ?1")
    Optional<Book> findBookByISBN(Long ISBN);
}
