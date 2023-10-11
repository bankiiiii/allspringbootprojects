package com.homework.homework.controller;

import com.homework.homework.model.SalaryRate;
import com.homework.homework.service.SalaryRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salaryrates")
public class SalaryRateController {

    private final SalaryRateService salaryRateService;

    @Autowired
    public SalaryRateController(SalaryRateService salaryRateService) {
        this.salaryRateService = salaryRateService;
    }

    @GetMapping
    public ResponseEntity<List<SalaryRate>> getAllSalaryRates() {
        List<SalaryRate> salaryRates = salaryRateService.getAllSalaryRates();
        return new ResponseEntity<>(salaryRates, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaryRate> getSalaryRateById(@PathVariable Long id) {
        SalaryRate salaryRate = salaryRateService.getSalaryRateById(id);
        if (salaryRate != null) {
            return new ResponseEntity<>(salaryRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<SalaryRate> createSalaryRate(@RequestBody SalaryRate salaryRate) {
        SalaryRate savedSalaryRate = salaryRateService.saveSalaryRate(salaryRate);
        return new ResponseEntity<>(savedSalaryRate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaryRate> updateSalaryRate(@PathVariable Long id, @RequestBody SalaryRate salaryRate) {
        SalaryRate existingSalaryRate = salaryRateService.getSalaryRateById(id);
        if (existingSalaryRate != null) {
            //salaryRate.setId(id);
            SalaryRate updatedSalaryRate = salaryRateService.saveSalaryRate(salaryRate);
            return new ResponseEntity<>(updatedSalaryRate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalaryRate(@PathVariable Long id) {
        SalaryRate existingSalaryRate = salaryRateService.getSalaryRateById(id);
        if (existingSalaryRate != null) {
            salaryRateService.deleteSalaryRate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

