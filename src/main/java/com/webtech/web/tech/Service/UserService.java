package com.webtech.web.tech.Service;

import java.util.List;

import com.webtech.web.tech.Model.Student;

public interface UserService {
    List<Student> getStudents(String parametr);
    Student getStudent(int id);
    boolean addStudent(Student student);
    boolean editStudent(Student student);
    void deleteStudent(int id);
}
