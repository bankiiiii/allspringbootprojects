package com.classwork.classwork.controller;

import com.classwork.classwork.model.Employee;
import com.classwork.classwork.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedDepartment = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> departments = employeeService.getAllEmployees();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null)
        {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeByID(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedDepartment = employeeService.updateEmployeeById(id, employee);

        if(updatedDepartment != null) {
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dept/{deptId}")
    public ResponseEntity<List<Employee>> getEmployeesByDeptId(@PathVariable Long deptId) {
        List<Employee> employee = employeeService.findEmployeesByDeptId(deptId);
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @GetMapping("/empCat/{empCatId}")
    public ResponseEntity<List<Employee>> getEmployeesByEmpCatId(@PathVariable Long empCatId) {
        List<Employee> employee = employeeService.findEmployeesByEmpCatId(empCatId);
        if (employee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }
}
