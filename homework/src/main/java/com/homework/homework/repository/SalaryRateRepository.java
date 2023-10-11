package com.homework.homework.repository;

import com.homework.homework.model.SalaryRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRateRepository extends JpaRepository<SalaryRate, Long> {
    // You can add custom query methods here if needed
}
