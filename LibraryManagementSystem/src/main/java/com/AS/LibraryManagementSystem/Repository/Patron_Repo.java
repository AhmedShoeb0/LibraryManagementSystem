package com.AS.LibraryManagementSystem.Repository;

import com.AS.LibraryManagementSystem.Model.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Patron_Repo extends JpaRepository<Patron,Integer> {

    @Query("SELECT p from Patron p where p.mail = ?1")
    Optional<Patron> findPatronByMail(String mail);
}
