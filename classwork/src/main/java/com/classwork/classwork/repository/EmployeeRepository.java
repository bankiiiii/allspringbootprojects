package com.classwork.classwork.repository;

import com.classwork.classwork.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    List<Employee> findByDeptId(Long deptId);
    List<Employee> findByEmpCatId(Long empCatId);
}
