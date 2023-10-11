package com.classwork.classwork.service;

import com.classwork.classwork.model.Employee;
import com.classwork.classwork.model.SalaryRate;
import com.classwork.classwork.repository.SalaryRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryRateService {

    @Autowired
    private final SalaryRateRepository salaryRateRepository;

    @Autowired
    public SalaryRateService (SalaryRateRepository salaryRateRepository){
        this.salaryRateRepository = salaryRateRepository;
    }

    public List<SalaryRate> getAllSalaryRate() {
        return  salaryRateRepository.findAll();
    }

    public SalaryRate getSalaryRateById(Long id) {
        return salaryRateRepository.findById(id).orElse(null);
    }

    public SalaryRate saveSalaryRate(SalaryRate salaryRate) {
        return salaryRateRepository.save(salaryRate);
    }

    public void deleteSalaryRateById(Long id) {
        salaryRateRepository.deleteById(id);
    }

    public SalaryRate updateSalaryRateById(Long id, SalaryRate newSalaryRate) {
        SalaryRate existingSalaryRate = salaryRateRepository.findById(id).orElse(null);
        if (existingSalaryRate != null) {
            // Update the properties of the existing salaryRate with the new values
            existingSalaryRate.setSalaryRateLevel(newSalaryRate.getSalaryRateLevel());
            existingSalaryRate.setSalaryRateAmount(newSalaryRate.getSalaryRateAmount());
            existingSalaryRate.setEmpCatId(newSalaryRate.getEmpCatId());

            return salaryRateRepository.save(existingSalaryRate);
        } else {
            // SalaryRate not found, return null or throw an exception, depending on your use case
            return null;
        }
    }

    public List<SalaryRate> findSalaryRateByEmpCatId(Long empCatId) {
        return salaryRateRepository.findByEmpCatId(empCatId);
    }
}
