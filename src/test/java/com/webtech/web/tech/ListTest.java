package com.webtech.web.tech;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import com.webtech.web.tech.Model.Student;
import com.webtech.web.tech.Service.UserServiceList;

public class ListTest {
    private static Student student;
    
    public static void setStudent (){
        student = new Student();
        student.setId(Integer.valueOf(1));
        student.setName("Иван");
        student.setSurname("Иванов");
        student.setThirdName("Иванович");
    }

    @Test
    void getTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        assertTrue(list.getStudent(student.getId()).equals(student));
    }

    @Test
    void addTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        assertTrue(list.getStudent(student.getId()).equals(student));
    }

    @Test
    void editTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        student.setName("TEST");
        assertTrue(list.getStudent(student.getId()).equals(student));
    }

    @Test
    void deleteTest(){
        setStudent();
        UserServiceList list = new UserServiceList();
        list.addStudent(student);
        list.deleteStudent(student.getId());
        assertTrue(ObjectUtils.isEmpty(list.getStudent(student.getId())));
    }

}
