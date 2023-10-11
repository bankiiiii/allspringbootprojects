package com.classwork.classwork.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_category")
public class EmployeeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_cat_id")
    private Long empCatId;

    @Column(name = "emp_cat_name")
    private String empCatName;

    @Column(name = "emp_cat_description")
    private String empCatDescription;

}
