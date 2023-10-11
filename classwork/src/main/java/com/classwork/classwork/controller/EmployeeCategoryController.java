package com.classwork.classwork.controller;

import com.classwork.classwork.model.EmployeeCategory;
import com.classwork.classwork.service.EmployeeCategoryService;
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
        public EmployeeCategoryController (EmployeeCategoryService employeeCategoryService){
            this.employeeCategoryService = employeeCategoryService;
        }

        @PostMapping
        public ResponseEntity<EmployeeCategory> createEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
            EmployeeCategory savedEmployeeCategory = employeeCategoryService.saveEmployeeCategory(employeeCategory);
            return new ResponseEntity<>(savedEmployeeCategory, HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<List<EmployeeCategory>> getAllEmployeeCategory() {
            List<EmployeeCategory> employeeCategories = employeeCategoryService.getAllEmployeeCategory();
            return new ResponseEntity<>(employeeCategories, HttpStatus.OK);
        }

        @GetMapping ("/{id}")
        public ResponseEntity<EmployeeCategory> getEmployeeCategoriesById(@PathVariable Long id) {
            EmployeeCategory employeeCategory = employeeCategoryService.getEmployeeCategoryById(id);
            if (employeeCategory != null)
            {
                return new ResponseEntity<>(employeeCategory, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        }

        @PutMapping ("/{id}")
        public ResponseEntity<EmployeeCategory> updateEmployeeCategoryByID(@PathVariable Long id, @RequestBody EmployeeCategory employeeCategory) {
            EmployeeCategory updatedEmployeeCategory = employeeCategoryService.updateEmployeeCategoryById(id, employeeCategory);

            if(updatedEmployeeCategory != null) {
                return new ResponseEntity<>(updatedEmployeeCategory, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping ("/{id}")
        public ResponseEntity<Void> deleteEmployeeCategoryById(@PathVariable Long id) {
            employeeCategoryService.deleteEmployeeCategoryById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }
