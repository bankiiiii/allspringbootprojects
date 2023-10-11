package com.classwork.classwork.controller;

import com.classwork.classwork.model.SalaryRate;
import com.classwork.classwork.model.SalaryRate;
import com.classwork.classwork.service.SalaryRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/salaryrates")
public class SalaryRateController {

    private final SalaryRateService salaryRateService;

    @Autowired
    public SalaryRateController (SalaryRateService salaryRateService){
        this.salaryRateService = salaryRateService;
    }

    @PostMapping
    public ResponseEntity<SalaryRate> createDepartment(@RequestBody SalaryRate salaryRate) {
        SalaryRate savedSalaryRate = salaryRateService.saveSalaryRate(salaryRate);
        return new ResponseEntity<>(savedSalaryRate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SalaryRate>> getAllDepartment() {
        List<SalaryRate> salaryRates = salaryRateService.getAllSalaryRate();
        return new ResponseEntity<>(salaryRates, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<SalaryRate> getSalaryRateById(@PathVariable Long id) {
        SalaryRate salaryRate = salaryRateService.getSalaryRateById(id);
        if (salaryRate != null)
        {
            return new ResponseEntity<>(salaryRate, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryRate> updateSalaryRateByID(@PathVariable Long id, @RequestBody SalaryRate salaryRate) {
        SalaryRate updatedDepartment = salaryRateService.updateSalaryRateById(id, salaryRate);

        if(updatedDepartment != null) {
            return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteSalaryRateById(@PathVariable Long id) {
        salaryRateService.deleteSalaryRateById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/empCat/{empCatId}")
    public ResponseEntity<List<SalaryRate>> getSalaryRateByEmpCatId(@PathVariable Long empCatId) {
        List<SalaryRate> salaryRate = salaryRateService.findSalaryRateByEmpCatId(empCatId);
        if (salaryRate.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(salaryRate, HttpStatus.OK);
        }
    }
}
