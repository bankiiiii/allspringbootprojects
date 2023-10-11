package com.assessor.assessor.repository;

import com.assessor.assessor.model.Assessor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessorRepository extends JpaRepository<Assessor, Long> {

    Assessor findByName(String name);

    Assessor findById(long id);

    Assessor deleteById(long id);
}
