package com.assessor.assessor.service;


import com.assessor.assessor.model.Assessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssessorService {

    Assessor getAssessorByName(String name);

    Assessor saveAssessor(Assessor assessor);

    List<Assessor> getAllAssessors();

    Assessor getAssessorById(long id);

    void deleteAssessorById(long id);
}
