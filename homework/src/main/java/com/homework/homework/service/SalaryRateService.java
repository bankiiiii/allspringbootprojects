package com.homework.homework.service;

import com.homework.homework.model.SalaryRate;
import com.homework.homework.repository.SalaryRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryRateService {

    private final SalaryRateRepository salaryRateRepository;

    @Autowired
    public SalaryRateService(SalaryRateRepository salaryRateRepository) {
        this.salaryRateRepository = salaryRateRepository;
    }

    public List<SalaryRate> getAllSalaryRates() {
        return salaryRateRepository.findAll();
    }

    public SalaryRate getSalaryRateById(Long id) {
        return salaryRateRepository.findById(id).orElse(null);
    }

    public SalaryRate saveSalaryRate(SalaryRate salaryRate) {
        return salaryRateRepository.save(salaryRate);
    }

    public void deleteSalaryRate(Long id) {
        salaryRateRepository.deleteById(id);
    }
}


