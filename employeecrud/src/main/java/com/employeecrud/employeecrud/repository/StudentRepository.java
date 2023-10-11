package com.employeecrud.employeecrud.repository;

import com.employeecrud.employeecrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//<Integer is the data type of the primary key which is the ID>
public interface StudentRepository extends JpaRepository <Student,Integer> {

    Student findByName(String name);

    Student findById(int id);

    Student deleteById(int id);
}
