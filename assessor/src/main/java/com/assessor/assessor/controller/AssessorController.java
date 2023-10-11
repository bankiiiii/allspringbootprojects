package com.assessor.assessor.controller;

import com.assessor.assessor.model.Assessor;
import com.assessor.assessor.service.AssessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssessorController {

    private final AssessorService assessorService;

    public AssessorController(AssessorService assessorService) {
        this.assessorService = assessorService;
    }

    @PostMapping("/addAssessor")
    public ResponseEntity<Object> postDetails(@RequestBody Assessor assessor) {
        // Check if the assessor name already exists in the database
        Assessor existingAssessor = assessorService.getAssessorByName(assessor.getName());

        if (existingAssessor != null) {
            // Handle the scenario when the assessor name already exists
            String errorMessage = "Assessor with the same name already exists.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // Save the new assessor since the name doesn't exist in the database
        Assessor savedAssessor = assessorService.saveAssessor(assessor);
        return new ResponseEntity<>(savedAssessor, HttpStatus.CREATED);
    }

    @GetMapping("/getAssessors")
    public ResponseEntity<List<Assessor>> getAllAssessors() {
        List<Assessor> assessors = assessorService.getAllAssessors();
        if (assessors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(assessors, HttpStatus.OK);
    }

    @DeleteMapping("deleteAssessor/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable long id) {
        // Check if the assessor exists with the given ID
        Assessor existingAssessor = assessorService.getAssessorById(id);

        if (existingAssessor == null) {
            // Handle the scenario when the assessor does not exist
            String errorMessage = "Assessor with ID " + id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

        // Delete the assessor since it exists in the database
        assessorService.deleteAssessorById(id);
        String successMessage = "Assessor with ID " + id + " deleted successfully.";
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping("getAssessor/{id}")
    public ResponseEntity<Assessor> getAssessorById(@PathVariable long id) {
        // Retrieve the assessor by ID from the service
        Assessor assessor = assessorService.getAssessorById(id);
        if (assessor == null) {
            // Handle the scenario when the assessor is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessor, HttpStatus.OK);
    }

    @PutMapping("updateAssessor/{id}")
    public ResponseEntity<Assessor> updateAssessorById(@PathVariable long id, @RequestBody Assessor updatedAssessor) {
        // Check if the assessor with the given ID exists in the database
        Assessor existingAssessor = assessorService.getAssessorById(id);
        if (existingAssessor == null) {
            // Handle the scenario when the assessor is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the assessor's data and save it to the database
        existingAssessor.setName(updatedAssessor.getName());
        existingAssessor.setNumber(updatedAssessor.getNumber());

        // Update other fields as needed...
        Assessor updatedAssessorInDb = assessorService.saveAssessor(existingAssessor);
        return new ResponseEntity<>(updatedAssessorInDb, HttpStatus.OK);
    }
}









