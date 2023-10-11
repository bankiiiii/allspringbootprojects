package com.classwork.classwork.service;


import com.classwork.classwork.model.Employee;
import com.classwork.classwork.model.Employee;
import com.classwork.classwork.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return  employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee (Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployeeById(Long id, Employee newDepartment) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            // Update the properties of the existing employee with the new values
            existingEmployee.setEmpName(newDepartment.getEmpName());
            existingEmployee.setEmpAddress(newDepartment.getEmpAddress());
            existingEmployee.setEmpPhone(newDepartment.getEmpPhone());
            existingEmployee.setEmpJoinedDate(newDepartment.getEmpJoinedDate());
            existingEmployee.setEmpDateOfBirth(newDepartment.getEmpDateOfBirth());
            existingEmployee.setDeptId(newDepartment.getDeptId());

            return employeeRepository.save(existingEmployee);
        } else {
            // Employee not found, return null or throw an exception, depending on your use case
            return null;
        }
    }

    public List<Employee> findEmployeesByDeptId(Long deptId) {
        return employeeRepository.findByDeptId(deptId);
    }

    public List<Employee> findEmployeesByEmpCatId(Long empCatId) {
        return employeeRepository.findByEmpCatId(empCatId);
    }
}
