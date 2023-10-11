package com.homework.homework.service;

import com.homework.homework.model.EmployeeCategory;
import com.homework.homework.repository.EmployeeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCategoryService {

    private final EmployeeCategoryRepository employeeCategoryRepository;

    @Autowired
    public EmployeeCategoryService(EmployeeCategoryRepository employeeCategoryRepository) {
        this.employeeCategoryRepository = employeeCategoryRepository;
    }

    public List<EmployeeCategory> getAllEmployeeCategories() {
        return employeeCategoryRepository.findAll();
    }

    public EmployeeCategory getEmployeeCategoryById(Long id) {
        return employeeCategoryRepository.findById(id).orElse(null);
    }

    public EmployeeCategory saveEmployeeCategory(EmployeeCategory employeeCategory) {
        return employeeCategoryRepository.save(employeeCategory);
    }

    public void deleteEmployeeCategory(Long id) {
        employeeCategoryRepository.deleteById(id);
    }
}
