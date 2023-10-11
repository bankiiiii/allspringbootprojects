package com.classwork.classwork.service;

import com.classwork.classwork.model.EmployeeCategory;
import com.classwork.classwork.repository.EmployeeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCategoryService {

    @Autowired
    private final EmployeeCategoryRepository employeeCategoryRepository;

    @Autowired
    public EmployeeCategoryService (EmployeeCategoryRepository employeeCategoryRepository){
        this.employeeCategoryRepository = employeeCategoryRepository;
    }

    public List<EmployeeCategory> getAllEmployeeCategory() {
        return  employeeCategoryRepository.findAll();
    }

    public EmployeeCategory getEmployeeCategoryById(Long id) {
        return employeeCategoryRepository.findById(id).orElse(null);
    }

    public EmployeeCategory saveEmployeeCategory(EmployeeCategory employeeCategory) {
        return employeeCategoryRepository.save(employeeCategory);
    }

    public void deleteEmployeeCategoryById(Long id) {
        employeeCategoryRepository.deleteById(id);
    }

    public EmployeeCategory updateEmployeeCategoryById(Long id, EmployeeCategory newDepartment) {
        EmployeeCategory existingEmployeeCategory = employeeCategoryRepository.findById(id).orElse(null);
        if (existingEmployeeCategory != null) {
            // Update the properties of the existing employeeCategory with the new values
            existingEmployeeCategory.setEmpCatName(newDepartment.getEmpCatName());
            existingEmployeeCategory.setEmpCatDescription(newDepartment.getEmpCatDescription());

            return employeeCategoryRepository.save(existingEmployeeCategory);
        } else {
            // EmployeeCategory not found, return null or throw an exception, depending on your use case
            return null;
        }
    }
}
