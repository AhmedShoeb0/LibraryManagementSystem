package com.AS.LibraryManagementSystem.Controller;

import com.AS.LibraryManagementSystem.Model.Book;
import com.AS.LibraryManagementSystem.Model.Patron;
import com.AS.LibraryManagementSystem.Service.Patron_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/patrons")
public class Patron_controller {
    private final Patron_Service patronService;

    @Autowired
    public Patron_controller(Patron_Service patronService) {
        this.patronService = patronService;
    }

    @GetMapping("")
    public List<Patron> getPatrons(){
        return patronService.getPatrons();
    }

    @GetMapping("/{id}")
    public Patron findByID(@PathVariable Integer id){
        return patronService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void ADD(@RequestBody Patron patron){
        patronService.addNewPatron(patron);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        patronService.deleteByID(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Patron patron, @PathVariable Integer id){
        if(!patronService.existByID(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        patronService.updatePatron(patron);
    }

}
