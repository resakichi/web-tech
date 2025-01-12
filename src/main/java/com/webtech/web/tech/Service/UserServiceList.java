package com.webtech.web.tech.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webtech.web.tech.Model.Student;

@Service
public class UserServiceList implements UserService {

    private final List<Student> storage = new ArrayList<>();

    @Override
    public List<Student> getStudents() {
        return storage;
    }

    @Override
    public Student getStudent(int id) {
        for (Student element : storage) {
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public Student addStudent(Student student) {
        storage.add(student);
        return student;
    }

    @Override
    public Student editStudent(Student student) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(student)){
                storage.set(i, student);
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId() == id) {
                storage.remove(i);
            }
        }
    }
    
}
