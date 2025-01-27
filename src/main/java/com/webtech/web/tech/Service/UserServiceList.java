package com.webtech.web.tech.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.webtech.web.tech.Model.Student;

@Service
@Profile("list")
public class UserServiceList implements UserService {

    private final List<Student> storage = new ArrayList<>();
    private int idCounter = 0;

    @Override
    public List<Student> getStudents(String param) {
        if (param == null){
            return storage;    
        }
        return storage.stream()
        .filter(obj -> obj.getName().contains(param))
        .collect(Collectors.toList());
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
    public boolean addStudent(Student student) {
        student.setId(idCounter++);
        return storage.add(student);
    }

    @Override
    public boolean editStudent(Student student) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(student)){
                storage.set(i, student);
                return true;
            }
        }
        return false;
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
