package com.webtech.web.tech.Service;

import java.util.List;
import java.util.Optional;

import com.webtech.web.tech.Model.Student;

public interface UserService {
    List<Student> getStudents();
    Student getStudent(int id);
    boolean addStudent(Student student);
    boolean editStudent(Student student);
    void deleteStudent(int id);
    
    default Optional<Student> filterByName(List<Student> rawList, String find){
        Optional<Student> result = rawList.stream()
                                    .filter(Student -> Student.getName().equals(find))
                                    .findAny();
        return result;
    }
}
