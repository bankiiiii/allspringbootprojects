package com.assessor.assessor.service.impl;



import com.assessor.assessor.model.Assessor;
import com.assessor.assessor.repository.AssessorRepository;
import com.assessor.assessor.service.AssessorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssessorServiceImpl implements AssessorService {

    private final AssessorRepository assessorRepository;

    public AssessorServiceImpl(AssessorRepository assessorRepository) {
        this.assessorRepository = assessorRepository;
    }

    @Override
    public Assessor getAssessorByName(String name) {
        return assessorRepository.findByName(name);
    }



    @Override
    public Assessor saveAssessor(Assessor assessor) {
        assessor.setDateJoined(LocalDate.now());
        return assessorRepository.save(assessor);
    }

    @Override
    public List<Assessor> getAllAssessors() {
        return assessorRepository.findAll();
    }



    //@Override;
    public Assessor getAssessorById(long id) {
        Optional<Assessor> assessorOptional = Optional.ofNullable(assessorRepository.findById(id));
        return assessorOptional.orElse(null);
    }


    //@Override
    public void deleteAssessorById(long id) {
        assessorRepository.deleteById(id);
    }

}
