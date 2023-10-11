package com.employeecrud.employeecrud.service.impl;

import com.employeecrud.employeecrud.model.Student;
import com.employeecrud.employeecrud.repository.StudentRepository;
import com.employeecrud.employeecrud.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        return studentOptional.orElse(null);
    }


    @Override
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }
}
