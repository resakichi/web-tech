package com.webtech.web.tech.Model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentWrapper {
    
    private List<Student> students;

    @XmlElement
    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students){
        this.students = students;
    }
}
