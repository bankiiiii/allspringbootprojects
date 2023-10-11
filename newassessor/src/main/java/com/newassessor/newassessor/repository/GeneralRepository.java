package com.newassessor.newassessor.repository;

import java.util.List;

public interface GeneralRepository <NewAssessor, Long>{

    NewAssessor save(NewAssessor newAssessor);
    NewAssessor findById(Long id);
    void deleteById(Long id);
    List<NewAssessor> findAll();
    NewAssessor update(NewAssessor newAssessor);
}
