package com.homework.homework.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Getter
@Setter
@Entity
@Table(name = "salary_rate")
public class SalaryRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long salaryRateId;

    @Column(name = "salary_rate_level")
    private String salaryRateLevel;

    @Column(name = "salary_rate_amount")
    private BigDecimal salaryRateAmount;

    @ManyToOne
    //@JoinColumn (name = "employee_category_emp_cat_id")
    private EmployeeCategory employeeCategory;//int

    // Constructors, getters, setters, and other methods
}

