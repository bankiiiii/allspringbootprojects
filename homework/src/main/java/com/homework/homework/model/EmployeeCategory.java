package com.homework.homework.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "employee_category")
public class EmployeeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empCatId;

    @Column(name = "emp_cat_name")
    private String empCatName;

    @Column(name = "emp_cat_description")
    private String empCatDescription;

    // Constructors, getters, setters, and other methods
}

