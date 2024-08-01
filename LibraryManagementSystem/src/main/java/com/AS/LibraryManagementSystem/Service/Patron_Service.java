package com.AS.LibraryManagementSystem.Service;

import com.AS.LibraryManagementSystem.Model.Patron;
import com.AS.LibraryManagementSystem.Repository.Patron_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Patron_Service {
private final Patron_Repo patronRepo;

    @Autowired
    public Patron_Service(Patron_Repo patronRepo) {
        this.patronRepo = patronRepo;
    }

    public List<Patron> getPatrons(){
        return patronRepo.findAll();
    }

    public final Optional<Patron> findById(Integer id) {
        return patronRepo.findById(id);
    }

    public void addNewPatron(Patron patron) {
        Optional<Patron> patronOptional = patronRepo.findPatronByMail(patron.getMail());
        if (patronOptional.isPresent()){
            throw new IllegalStateException("This mail is already there.");
        }
        patronRepo.save(patron);
    }

    public void deleteByID(Integer id) {
        boolean exist = patronRepo.existsById(id);
        if(!exist){
            throw new IllegalStateException("Patron with id " + id + " does not exist");
        }
        patronRepo.deleteById(id);
    }

    public void updatePatron(Patron patron) {
        patronRepo.findAll().removeIf(c -> c.getId().equals(patron.getId()));
        patronRepo.save(patron);
    }

    public boolean existByID(Integer id) {
            return patronRepo.findAll().stream().filter(c -> c.getId().equals(id)).count()==1;
        }

}
