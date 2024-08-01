package com.AS.LibraryManagementSystem.Service;


import com.AS.LibraryManagementSystem.Model.Borrowing_record;
import com.AS.LibraryManagementSystem.Repository.Record_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Record_Service {
private final Record_Repo recordRepo;

    @Autowired
    public Record_Service(Record_Repo recordRepo) {
        this.recordRepo = recordRepo;
    }

    public List<Borrowing_record> getRecords(){
        return recordRepo.findAll();
    }

    public final Optional<Borrowing_record> findById(Integer id) {
        return recordRepo.findById(id);
    }

    public void borrowBook(Borrowing_record record) {
        recordRepo.save(record);
    }

    public void deleteByID(Integer id) {
        boolean exist = recordRepo.existsById(id);
        if(!exist){
            throw new IllegalStateException("Record with id " + id + " does not exist");
        }
        recordRepo.deleteById(id);
    }

    public void updateReturnDate(Borrowing_record record) {
        recordRepo.findAll().removeIf(c -> c.getRecord_id().equals(record.getRecord_id()));
        record.setReturn_date(LocalDateTime.now());
        recordRepo.save(record);
    }

    public boolean existByID(Integer id) {
            return recordRepo.findAll().stream().filter(c -> c.getRecord_id().equals(id)).count()==1;
        }

}
