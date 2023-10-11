package com.newassessor.newassessor.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table (name = "new_assessor")
@Setter
@Getter

public class NewAssessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;


    @Column(name = "dateJoined")
    private LocalDate dateJoined;

}

//    public void setDateJoined(LocalDate dateJoined) {
//        this.dateJoined = dateJoined;
//    }



