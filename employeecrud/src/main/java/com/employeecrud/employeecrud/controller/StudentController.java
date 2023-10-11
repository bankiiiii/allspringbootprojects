package com.employeecrud.employeecrud.controller;



import com.employeecrud.employeecrud.model.Student;
import com.employeecrud.employeecrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> postDetails(@RequestBody Student student) {
        // Check if the student name already exists in the database
        Student existingStudent = studentService.getStudentByName(student.getName());

        if (existingStudent != null) {
            // Handle the scenario when the student name already exists
            String errorMessage = "Student with the same name already exists.";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        // Save the new student since the name doesn't exist in the database
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/getStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("deleteStudent/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        // Check if the student exists with the given ID
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent == null) {
            // Handle the scenario when the student does not exist
            String errorMessage = "Student with ID " + id + " not found.";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

        // Delete the student since it exists in the database
        studentService.deleteStudentById(id);
        String successMessage = "Student with ID " + id + " deleted successfully.";
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    @GetMapping("getStudent/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        // Retrieve the student by ID from the service
        Student student = studentService.getStudentById(id);
        if (student == null) {
            // Handle the scenario when the student is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("updateStudent/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student updatedStudent) {
        // Check if the student with the given ID exists in the database
        Student existingStudent = studentService.getStudentById(id);
        if (existingStudent == null) {
            // Handle the scenario when the student is not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update the student's data and save it to the database
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setMark(updatedStudent.getMark());

        // Update other fields as needed...
        Student updatedStudentInDb = studentService.saveStudent(existingStudent);
        return new ResponseEntity<>(updatedStudentInDb, HttpStatus.OK);
    }
}


