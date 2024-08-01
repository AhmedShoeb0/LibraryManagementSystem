package com.AS.LibraryManagementSystem.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Patron {
    @Id
    @SequenceGenerator(name= "patron_sequence",
            sequenceName = "patron_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patron_sequence"
    )
    private Integer     id;
    private String      name;
    private String      contact_information;
    private String      mail;


    public Patron(){
    }

    public Patron(Integer id,
                  String name,
                  String contact_information,
                  String mail){
        this.id=id;
        this.name=name;
        this.contact_information=contact_information;
        this.mail=mail;
    }

    public Patron(String name,
                  String contact_information,
                  String mail){

        this.name=name;
        this.contact_information=contact_information;
        this.mail=mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact_information() {
        return contact_information;
    }

    public void setContact_information(String contact_information) {
        this.contact_information = contact_information;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
