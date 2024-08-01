package com.AS.LibraryManagementSystem.Controller;


import com.AS.LibraryManagementSystem.Model.Borrowing_record;
import com.AS.LibraryManagementSystem.Service.Record_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/borrow")
public class Record_controller {
    private final Record_Service recordService;

    @Autowired
    public Record_controller(Record_Service recordService) {
        this.recordService = recordService;
    }

    @GetMapping("")
    public List<Borrowing_record> getRecords(){
        return recordService.getRecords();
    }

    @GetMapping("/{id}")
    public Borrowing_record findByID(@PathVariable Integer id){
        return recordService.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void ADD(@RequestBody Borrowing_record record){
        recordService.borrowBook(record);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        recordService.deleteByID(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Borrowing_record record, @PathVariable Integer id){
        if(!recordService.existByID(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        recordService.updateReturnDate(record);
    }

}
