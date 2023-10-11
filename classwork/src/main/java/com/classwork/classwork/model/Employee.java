package com.classwork.classwork.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table (name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_address")
    private String empAddress;

    @Column(name = "emp_phone")
    private String empPhone;

    @Column(name = "emp_joined_date")
    private Date empJoinedDate;

    @Column(name = "emp_date_of_birth")
    private Date empDateOfBirth;

    @Column(name = "dept_id")
    private Long deptId;

    @Column(name = "emp_cat_id")
    private Long empCatId;

}
