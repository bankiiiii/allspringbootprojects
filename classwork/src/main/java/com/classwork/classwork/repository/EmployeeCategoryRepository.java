package com.classwork.classwork.repository;

import com.classwork.classwork.model.EmployeeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCategoryRepository extends JpaRepository<EmployeeCategory, Long> {
}
