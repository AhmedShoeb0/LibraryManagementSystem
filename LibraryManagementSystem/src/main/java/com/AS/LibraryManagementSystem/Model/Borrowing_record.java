package com.AS.LibraryManagementSystem.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "borrowing_record")
public class Borrowing_record {
    @Id
    @SequenceGenerator(name= "record_sequence",
            sequenceName = "record_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "record_sequence"
    )
   private Integer record_id;
   //private Integer book_id;
   private Integer patron_id;
    @Transient
   private LocalDateTime borrowing_date;
   private LocalDateTime return_date;

    //Relationships
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;


   //Constructors
   public Borrowing_record(){}

    public Borrowing_record(Integer record_id,
                            Integer patron_id,
                            LocalDateTime borrowing_date,
                            LocalDateTime return_date){
       this.record_id=record_id;
       this.patron_id=patron_id;
       this.borrowing_date=borrowing_date;
       this.return_date=return_date;
    }

    public Borrowing_record(Integer patron_id,
                            LocalDateTime borrowing_date,
                            LocalDateTime return_date){

        this.patron_id=patron_id;
        this.borrowing_date=borrowing_date;
        this.return_date=return_date;
    }


    //Setters & Getters
    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public Integer getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(Integer patron_id) {
        this.patron_id = patron_id;
    }

    public LocalDateTime getBorrowing_date() {
        return LocalDateTime.now();
    }

    public void setBorrowing_date(LocalDateTime date) {

       this.borrowing_date = date;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }
}
