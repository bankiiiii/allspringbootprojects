package com.newassessor.newassessor.controller;

import com.newassessor.newassessor.model.NewAssessor;
import com.newassessor.newassessor.service.AssessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessors")
public class AssessorController {

    @Autowired
    private AssessorService assessorService;

    @PostMapping
    public NewAssessor saveAssessor(@RequestBody NewAssessor assessor) {
        return assessorService.saveAssessor(assessor);
    }

    @GetMapping("/{id}")
    public NewAssessor getAssessorById(@PathVariable long id) {
        return assessorService.getAssessorById(id);
    }

    @GetMapping
    public List<NewAssessor> getAllAssessors() {
        return assessorService.getAllAssessors();
    }

    @PutMapping("/{id}")
    public NewAssessor updateAssessor(@PathVariable long id, @RequestBody NewAssessor updatedAssessor) {
        return assessorService.updateAssessor(id, updatedAssessor);
    }

    @DeleteMapping("/{id}")
    public void deleteAssessor(@PathVariable long id) {
        assessorService.deleteAssessor(id);
    }
}
