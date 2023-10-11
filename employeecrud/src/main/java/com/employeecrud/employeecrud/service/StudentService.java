package com.employeecrud.employeecrud.service;


//in the service, we will be able to access the entity (model)tru the repo variable
//we cant accesss the entity directly only thru the help of the repo

import com.employeecrud.employeecrud.model.Student;
import com.employeecrud.employeecrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface StudentService {
    Student getStudentByName(String name);

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);
}

