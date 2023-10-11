package com.homework.homework.controller;

import com.homework.homework.model.EmployeeCategory;
import com.homework.homework.service.EmployeeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeecategories")
public class EmployeeCategoryController {

    private final EmployeeCategoryService employeeCategoryService;

    @Autowired
    public EmployeeCategoryController(EmployeeCategoryService employeeCategoryService) {
        this.employeeCategoryService = employeeCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeCategory>> getAllEmployeeCategories() {
        List<EmployeeCategory> employeeCategories = employeeCategoryService.getAllEmployeeCategories();
        return new ResponseEntity<>(employeeCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeCategory> getEmployeeCategoryById(@PathVariable Long id) {
        EmployeeCategory employeeCategory = employeeCategoryService.getEmployeeCategoryById(id);
        if (employeeCategory != null) {
            return new ResponseEntity<>(employeeCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EmployeeCategory> createEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
        EmployeeCategory savedEmployeeCategory = employeeCategoryService.saveEmployeeCategory(employeeCategory);
        return new ResponseEntity<>(savedEmployeeCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeCategory> updateEmployeeCategory(@PathVariable Long id, @RequestBody EmployeeCategory employeeCategory) {
        EmployeeCategory existingEmployeeCategory = employeeCategoryService.getEmployeeCategoryById(id);
        if (existingEmployeeCategory != null) {
            //employeeCategory.setId(id);
            EmployeeCategory updatedEmployeeCategory = employeeCategoryService.saveEmployeeCategory(employeeCategory);
            return new ResponseEntity<>(updatedEmployeeCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeCategory(@PathVariable Long id) {
        EmployeeCategory existingEmployeeCategory = employeeCategoryService.getEmployeeCategoryById(id);
        if (existingEmployeeCategory != null) {
            employeeCategoryService.deleteEmployeeCategory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
