package com.webtech.web.tech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Repository.StudentRepository;


@Service
@Profile("database")
public class UserServiceDatabase implements UserService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getStudents(String parameter) {
        if (parameter == null){
            return repository.findAll();    
        }
        return repository.filterByName(parameter);
    }

    @Override
    public Student getStudent(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean addStudent(Student student){
        try{
            repository.save(student);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean editStudent(Student student) {
        try {
            repository.save(student);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}
