package com.classwork.classwork.service;

import com.classwork.classwork.model.Department;
import com.classwork.classwork.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService (DepartmentRepository departmentRepository){
         this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return  departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartmentById(Long id, Department newDepartment) {
        Department existingDepartment = departmentRepository.findById(id).orElse(null);
        if (existingDepartment != null) {
            // Update the properties of the existing department with the new values
            existingDepartment.setDeptName(newDepartment.getDeptName());
            existingDepartment.setDeptDescription(newDepartment.getDeptDescription());
            existingDepartment.setManagerId(newDepartment.getManagerId());

            return departmentRepository.save(existingDepartment);
        } else {
            // Department not found, return null or throw an exception, depending on your use case
            return null;
        }
    }

    public List<Department> findDepartmentByManagerId(Long managerId) {
        return departmentRepository.findByManagerId(managerId);
    }
}
