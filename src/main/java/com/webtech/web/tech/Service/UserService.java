package com.webtech.web.tech.Service;

import java.util.List;

import com.webtech.web.tech.Model.Student;

public interface UserService {
    List<Student> getStudents();
    Student getStudent(int id);
    Student addStudent(Student student);
    Student editStudent(Student student);
    void deleteStudent(int id);
}
