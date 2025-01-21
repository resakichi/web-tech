package com.webtech.web.tech.Service;

import java.util.List;

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

    @Override
    public List<Student> getStudents() {
        return marshaller.unmarshallList();
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
