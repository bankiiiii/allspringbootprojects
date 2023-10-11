package com.assessor.assessor.model;

import jakarta.persistence.*;
//import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table
@Setter
@Getter
public class Assessor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;


    @Column(name = "dateJoined")
    private LocalDate dateJoined;


//    public void setDateJoined(LocalDate dateJoined) {
//        this.dateJoined = dateJoined;
//    }

}

