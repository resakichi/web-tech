package com.webtech.web.tech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Repository.StudentRepository;


@Service
public class UserServiceDatabase implements UserService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        return repository.findById(id);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student editStudent(Student student) {
        Student entity = repository.save(student);
        return entity;
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
    
}
