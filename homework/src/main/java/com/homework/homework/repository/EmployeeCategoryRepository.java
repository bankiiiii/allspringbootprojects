package com.homework.homework.repository;

import com.homework.homework.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Long> {
    // You can add custom query methods here if needed
}
