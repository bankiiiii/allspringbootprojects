package com.homework.homework.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeName;

    private String employeeAddress;

    private String employeePhone;

    private Date employeeJoinedDate;

    private Date employeeDateOfBirth;

    @ManyToOne
    private EmployeeCategory employeeCategory;

//    @ManyToOne
//    private Department department;


}


