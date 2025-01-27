package com.webtech.web.tech.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Repository.StudentXMLMarshall;

@Service
@Profile("xml")
public class UserServiceXML implements UserService{

    @Autowired
    private StudentXMLMarshall marshaller;

    private int idCounter = 0;

    @Override
    public List<Student> getStudents(String parameter) {
        if (parameter == null){
            return marshaller.unmarshallList();    
        }
        
        var listStudents = marshaller.unmarshallList();
        return listStudents.stream()
                .filter(obj -> obj.getName().contains(parameter))
                .collect(Collectors.toList());
    }

    @Override
    public Student getStudent(int id) {
        var listStudents = marshaller.unmarshallList();
        
        for (Student student : listStudents) {
            if (student.getId() == id){
                return student;
            }
        }

        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        var listStudents = marshaller.unmarshallList();
        student.setId(idCounter++);
        listStudents.add(student);
        return marshaller.marshallList(listStudents);
    }

    @Override
    public boolean editStudent(Student student) {
        var listStudents = marshaller.unmarshallList();

        for (int i = 0; i < listStudents.size(); i++) {
            if(listStudents.get(i).getId() == student.getId()){
                listStudents.remove(i);
                listStudents.add(student);
                return true;
            }
        }

        return false;
    }

    @Override
    public void deleteStudent(int id) {
        var listStudents = marshaller.unmarshallList();
        
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getId() == id) {
                listStudents.remove(i);
            }
        }
        marshaller.marshallList(listStudents);
    }

}
