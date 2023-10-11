package com.classwork.classwork.repository;

import com.classwork.classwork.model.Department;
import com.classwork.classwork.model.SalaryRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByManagerId(Long managerId);
}
