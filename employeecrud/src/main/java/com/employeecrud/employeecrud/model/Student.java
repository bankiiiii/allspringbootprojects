package com.employeecrud.employeecrud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @Column(name = "ID")
   // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "MARK")
    private int mark;

    @Column(name = "NAME")
    private String name;
}
