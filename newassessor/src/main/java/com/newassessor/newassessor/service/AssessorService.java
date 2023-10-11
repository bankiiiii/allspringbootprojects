package com.newassessor.newassessor.service;

import com.newassessor.newassessor.model.NewAssessor;
import com.newassessor.newassessor.repository.DatabaseRepository;
import com.newassessor.newassessor.repository.HashMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AssessorService {

    @Autowired
    private DatabaseRepository databaseRepository;

    @Autowired
    private HashMapRepository hashMapRepository;

    public NewAssessor saveAssessor(NewAssessor assessor) {
        // Save to both the database and the HashMap
        assessor.setDateJoined(LocalDate.now());
        NewAssessor savedAssessor = databaseRepository.save(assessor);
        hashMapRepository.save(assessor);
        return savedAssessor;
    }

    public NewAssessor getAssessorById(long id) {
        NewAssessor assessor = hashMapRepository.findById(id);
        if (assessor == null) {
            // If the assessor is not found in the HashMap or database
            ////return databaseRepository.findById(id).orElse(null);
            Optional<NewAssessor> databaseAssessor = databaseRepository.findById(id);
            return databaseAssessor.orElse(null);
        }
        return assessor;
    }

    public List<NewAssessor> getAllAssessors() {
        return hashMapRepository.findAll();
    }

    public NewAssessor updateAssessor(long id, NewAssessor updatedAssessor) {
        // Update in both the database and the HashMap
        NewAssessor updatedInDB = databaseRepository.save(updatedAssessor);
        hashMapRepository.update(updatedAssessor);
        return updatedInDB;
    }

    public void deleteAssessor(long id) {
        // Delete from both the database and the HashMap
        databaseRepository.deleteById(id);
        hashMapRepository.deleteById(id);
    }
}

