package com.classwork.classwork.repository;

import com.classwork.classwork.model.SalaryRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRateRepository extends JpaRepository<SalaryRate, Long> {

    List<SalaryRate> findByEmpCatId(Long empCatId);
}
