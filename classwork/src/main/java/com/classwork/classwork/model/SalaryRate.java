package com.classwork.classwork.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table (name = "salary_rate")
public class SalaryRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_rate_id")
    private Long salaryRateId;

    @Column(name = "salary_rate_level")
    private String salaryRateLevel;

    @Column(name = "salary_rate_amount")
    private BigDecimal salaryRateAmount;

    @Column(name = "emp_cat_id")
    private Long empCatId;

}
