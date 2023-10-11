package com.homework.homework.service;

import com.homework.homework.model.Department;
import com.homework.homework.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {

        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {

        departmentRepository.deleteById(id);
    }
}

