package com.webtech.web.tech.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.webtech.web.tech.Model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    List<Student> findAll();
    Student findById(int id);
}
